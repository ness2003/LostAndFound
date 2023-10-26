package command.client;

import command.ActionCommand;
import command.AddUserCommand;
import command.BlockUserCommand;
import command.ChangeFindingCommand;
import command.ChangeUserCommand;
import command.DeleteUserCommand;
import command.FindingsCommand;
import command.HomeCommand;
import command.InformationAboutProjectCommand;
import command.LoginCommand;
import command.LogoutCommand;
import command.MyFindingsCommand;
import command.MyTasksCommand;
import command.PfrofileCommand;
import command.RefreshFindingsCommand;
import command.RefreshUsersCommand;
import command.UsersCommand;

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
	FINDINGS {
		{
			this.command = new FindingsCommand();
		}
	},
	MYFINDINGS{
		{
			this.command = new MyFindingsCommand();
		}
	},
	MYPROFILE {
		{
			this.command = new PfrofileCommand();
		}
	},
	USERS {
		{
			this.command = new UsersCommand();
		}
	},
	ABOUTPROJECT {
		{
			this.command = new InformationAboutProjectCommand();
		}
	},
	ADDUSER{
		{
			this.command = new AddUserCommand();
		}
	},
	MYTASKS{
		{
			this.command = new MyTasksCommand();
		}
	},
	REFRESHUSERS{
		{
		this.command = new RefreshUsersCommand();
		}
	},
	BLOCKUSER{
		{
			this.command = new BlockUserCommand();
		}
		
	},
	DELETEUSER{
		{
			this.command = new DeleteUserCommand();
		}
		
	},
	CHANGEUSER{
		{
			this.command = new ChangeUserCommand();
		}
		
	},
	CHANGEFINDING{
		{
			this.command = new ChangeFindingCommand();
		}
	},
	REFRESHFINDINGS{
		{
			this.command = new RefreshFindingsCommand();
		}
	};
	

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}

}
