package filter;

import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import resource.ConfigurationManager;
//import resource.MessageManager;

import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра (если необходимо)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        HttpSession session = httpRequest.getSession(false);
//        boolean loggedIn = session.getAttribute("userId") != null;
//        String currentURI = httpRequest.getRequestURI(); // Путь к странице входа // Путь к странице входа
//        String loginPage = "/Lost-And-Found/";
//        String homePage = "/Lost-And-Found/home";// Путь к странице входа // Путь к странице входа

        // Проверяем, авторизован ли пользователь
//        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
//        boolean loggedInRequest = httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/Lost-And-Found/");

//        if (loggedIn || (!loggedIn && currentURI.equals(loginPage))) {
//            chain.doFilter(request, response); // Продолжаем выполнение цепочки фильтров
//        } else if ((!loggedIn && !currentURI.equals(loginPage)&&!currentURI.equals(homePage))){
//        	System.out.print("отработал");
//        	 String page = ConfigurationManager.getProperty("path.page.index"); // /index.jsp
//        	 httpRequest.getSession().setAttribute("showTimeoutMessage", false);
//     	    httpRequest.getSession().setAttribute("nullPage", MessageManager.getProperty("message.nullpage"));
//     	    httpResponse.sendRedirect(httpRequest.getContextPath() + page);
//     	   // return;
//        }
    }

    @Override
    public void destroy() {
        // Очистка ресурсов (если необходимо)
    }
}
