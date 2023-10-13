package command.client;

import command.ActionCommand;
import command.FindingsCommand;
import command.LoginCommand;
import command.LogoutCommand;
import controller.UserProfile;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	FINDINGS {
		{
			this.command = new FindingsCommand();
		}
	},
	GETUSERPROFILE {
		{
			this.command = new UserProfile();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}

}
