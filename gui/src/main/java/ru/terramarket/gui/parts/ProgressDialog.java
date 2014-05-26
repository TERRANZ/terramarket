package ru.terramarket.gui.parts;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.terramarket.gui.service.LoginService;


/**
 * Date: 28.04.14
 * Time: 13:32
 */
public class ProgressDialog {
    public static Stage create(final LoginService service, Stage owner, boolean indeterminate) {
        final Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        final BorderPane root = new BorderPane();
        final ProgressIndicator indicator = new ProgressIndicator();
        // have the indicator display the progress of the service:
        if (!indeterminate)
            indicator.progressProperty().bind(service.progressProperty());
        else
            indicator.progressProperty().setValue(-1);

        // hide the currStage when the service stops running:
        service.stateProperty().addListener(new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends State> observable,
                                State oldValue, State newValue) {
                if (newValue == State.CANCELLED || newValue == State.FAILED
                        || newValue == State.SUCCEEDED) {
                    stage.hide();
                }
            }
        });
        // A cancel button:
        Button cancel = new Button("Cancel");
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                service.cancel();
            }
        });
        root.setCenter(indicator);
        root.setBottom(cancel);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        return stage;
    }
}
