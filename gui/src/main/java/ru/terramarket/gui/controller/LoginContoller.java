package ru.terramarket.gui.controller;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.terramarket.gui.parts.ProgressDialog;
import ru.terramarket.gui.parts.StageHelper;
import ru.terramarket.gui.service.LoginService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Date: 16.05.14
 * Time: 17:43
 */
public class LoginContoller implements Initializable {
    @FXML
    public TextField tfUser;
    @FXML
    public TextField tfPass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void login(ActionEvent actionEvent) {
        LoginService loginService = new LoginService(tfUser.getText(), tfPass.getText());
        ProgressDialog.create(loginService, StageHelper.currStage, true);
        loginService.reset();
        loginService.start();
        loginService.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                System.out.println(loginService.getValue());
            }
        });
    }

    public void cancel(ActionEvent actionEvent) {
    }
}
