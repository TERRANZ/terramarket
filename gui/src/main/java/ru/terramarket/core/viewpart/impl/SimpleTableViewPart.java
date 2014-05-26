package ru.terramarket.core.viewpart.impl;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ru.terramarket.core.viewpart.AbstractViewPart;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Date: 26.05.14
 * Time: 15:41
 */
public class SimpleTableViewPart<T> extends AbstractViewPart {
    @FXML
    public Button btnRefresh;
    @FXML
    public TableView<T> table;

    private class LoadService extends Service<ObservableList<T>> {
        @Override
        protected Task<ObservableList<T>> createTask() {
            return new Task<ObservableList<T>>() {
                @Override
                protected ObservableList<T> call() throws Exception {
                    return null;
                }
            };
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnRefresh.setOnAction(actionEvent -> {
            load();
        });
    }

    public static void load() {

    }
}
