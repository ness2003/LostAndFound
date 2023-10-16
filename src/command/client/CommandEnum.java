package command.client;

import command.ActionCommand;
import command.FindingsCommand;
import command.HomeCommand;
import command.InformationAboutProjectCommand;
import command.LoginCommand;
import command.LogoutCommand;
import command.PfrofileCommand;

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
	HOME {
		{
			this.command = new HomeCommand();
		}
	},
	FINDS {
		{
			this.command = new FindingsCommand();
		}
	},
	MYPROFILE {
		{
			this.command = new PfrofileCommand();
		}
	},
	ABOUTPROJECT {
		{
			this.command = new InformationAboutProjectCommand();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}

}
