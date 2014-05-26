package ru.terramarket.gui.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import ru.terra.server.dto.LoginDTO;

/**
 * Date: 16.05.14
 * Time: 17:53
 */
public class LoginService extends Service<LoginDTO> {

    private final String user;
    private final String pass;

    public LoginService(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    @Override
    protected Task<LoginDTO> createTask() {
        return new Task<LoginDTO>() {
            @Override
            protected LoginDTO call() throws Exception {
                return null;
            }
        };
    }
}
