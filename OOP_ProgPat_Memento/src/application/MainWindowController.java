package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainWindowController implements Initializable {

    @FXML
    private TextArea txtAreaText;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnRedo;

    @FXML
    void redoText(ActionEvent event) {

    }

    @FXML
    void saveText(ActionEvent event) {

    }

    @FXML
    void undoText(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txtAreaText.setWrapText(true);
		
	}

}
