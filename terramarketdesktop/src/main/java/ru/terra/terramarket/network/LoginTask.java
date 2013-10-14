package ru.terra.terramarket.network;

import java.util.concurrent.Callable;

import org.eclipse.swt.widgets.Shell;

import ru.terra.terramarket.core.SessionHolder;
import ru.terra.terramarket.dto.LoginDTO;

public class LoginTask implements Callable<Boolean> {

	private String user, pass;
	private Shell shell;

	public LoginTask(Shell shell, String user, String pass) {
		super();
		this.shell = shell;
		this.user = user;
		this.pass = pass;
	}

	@Override
	public Boolean call() throws Exception {
		LoginDTO res = new RestClient(shell).login(user, pass);
		if (res != null) {
			if (res.logged) {
				SessionHolder.sessionId = "JSESSIONID=" + res.session;
				return true;
			}
		}
		return false;
	}
}
