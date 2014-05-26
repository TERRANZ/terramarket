package ru.terramarket.gui.parts;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ru.terramarket.gui.util.Pair;

import java.io.IOException;
import java.net.URL;

/**
 * Date: 28.04.14
 * Time: 13:27
 */
public class StageHelper {
    public static Stage currStage, prevStage;

    public static <T> Pair<Stage, T> openWindow(String fxmlFileName, String title, boolean closeCurr) {
        String fxmlFile = C.FXML + fxmlFileName;
        URL location = StageHelper.class.getResource(fxmlFile);
        Parent root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(location.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        if (closeCurr) {
            StageHelper.currStage.close();
            prevStage = null;
        }
        prevStage = currStage;
        StageHelper.currStage = stage;
        stage.getScene().getStylesheets().addAll(C.STYLE + "style.css");
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                currStage = prevStage;
                prevStage = null;//TODO: ??
            }
        });
        return new Pair<>(stage, (T) fxmlLoader.getController());
    }

    public static void closeCurrentWindow() {
        currStage.close();
    }
}
