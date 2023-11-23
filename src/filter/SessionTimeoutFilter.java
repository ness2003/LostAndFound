package filter;

import javax.servlet.*;
import javax.servlet.http.*;

import resource.ConfigurationManager;
import resource.MessageManager;

import java.io.IOException;

public class SessionTimeoutFilter implements Filter {
	private int timeout;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String timeoutParam = filterConfig.getInitParameter("timeout");
		timeout = (timeoutParam != null) ? Integer.parseInt(timeoutParam) : 1; // Время сессии в минутах
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);
		if (session == null) {
			session = httpRequest.getSession(true);
		}
		long currentTime = System.currentTimeMillis();
		long lastAccessedTime = session.getLastAccessedTime();
		long inactiveInterval = currentTime - lastAccessedTime;
		if (inactiveInterval > timeout * 60 * 1000 && session.getAttribute("userId") != null) {
			session.invalidate();
			String page = ConfigurationManager.getProperty("path.page.index");
			httpRequest.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
			httpRequest.getSession().setAttribute("showTimeoutMessage", true);
			httpResponse.sendRedirect(httpRequest.getContextPath() + page);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}
