package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MainWindowController {

    @FXML
    private TextArea txtAreaMessage;

    @FXML
    private Button btnSendMessage;

    @FXML
    private ListView<String> lstViewMessages;

    @FXML
    void sendingTheMessage(ActionEvent event) {

    }
}
