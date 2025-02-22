package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class MainWindowController implements Initializable {

    @FXML
    private TextArea txtAreaMessage;

    @FXML
    private Button btnSendMessage;

    @FXML
    private ListView<String> lstViewMessages;

    @FXML
    void sendingTheMessage(ActionEvent event) {
    	if(! txtAreaMessage.getText().isEmpty()) {
    		DataBaseInterfaceLikeClass interf = DataBaseInterfaceLikeClass.getSingletonInterface();
    		interf.addNewMessageToDB(txtAreaMessage.getText());
    		lstViewMessages.itemsProperty().set(interf.loadInMessagesFromDB());
    		txtAreaMessage.setText("");
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DataBaseInterfaceLikeClass interf = DataBaseInterfaceLikeClass.getSingletonInterface();
		lstViewMessages.itemsProperty().set(interf.loadInMessagesFromDB());
		
	}
}
