package ru.terra.terramarket.network;

import java.util.concurrent.Callable;

import ru.terra.terramarket.core.SessionHolder;
import ru.terra.terramarket.dto.LoginDTO;

public class LoginTask implements Callable<Boolean> {

	private String user, pass;

	public LoginTask(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	@Override
	public Boolean call() throws Exception {
		LoginDTO res = new RestClient().login(user, pass);
		if (res != null) {
			if (res.logged) {
				SessionHolder.sessionId = "JSESSIONID=" + res.session;
				return true;
			}
		}
		return false;
	}
}
