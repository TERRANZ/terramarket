package ru.terramarket.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.terramarket.gui.parts.StageHelper;

/**
 * Date: 16.05.14
 * Time: 16:15
 */
public class Main extends Application {
    public static void main(String... args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        StageHelper.openWindow("w_login.fxml", "Login", false);
    }
}
