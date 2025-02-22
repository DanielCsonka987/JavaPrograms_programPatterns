package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.ServiceOfAdaptorMessenger.Operation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable{
	
    @FXML
    private TextArea txtAreaLongMessage;

    @FXML
    private TextField txtFieldShortMessage;

    @FXML
    private Button btnLongMessage;

    @FXML
    private Button btnShortMessage;

    @FXML
    private Button btnCalculateMessage;

    @FXML
    private TextField txtFieldNum1;

    @FXML
    private TextField txtFieldNum2;

    @FXML
    private ComboBox<String> cmbbxProcess;
    
    @FXML
    private ListView<String> listResult;

    private ServiceOfAdaptorMessenger service;
    private Integer maxLength = 25;
	private Pattern p = Pattern.compile("[a-zA-Z]");
	private Matcher m;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new ServiceOfAdaptorMessenger();
		txtFieldShortMessage.textProperty().addListener(new ChangeListener<String>() {
	        @Override
	        public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
	            if (txtFieldShortMessage.getText().length() > maxLength) {
	                String s = txtFieldShortMessage.getText().substring(0, maxLength);
	                txtFieldShortMessage.setText(s);
	            }
	        }
	    });
	}
	
    @FXML
    void calculateAndSendMessage(ActionEvent event) {
    	if(cmbbxProcess.getSelectionModel().isEmpty())
    		return;
    	if(txtFieldNum1.getText().isEmpty() || txtFieldNum2.getText().isEmpty())
    		return;
    	m = p.matcher(txtFieldNum1.getText());
    	if(m.find())
    		return;
    	m = p.matcher(txtFieldNum2.getText());
    	if(m.find())
    		return;
    	doCalculateAndSendWithAdaptor(
    			reviseTheDataToCalulateAndSend(1), reviseTheDataToCalulateAndSend(2)
    			);
    	loadInMessageListAndResetFields();
    }

    private Integer reviseTheDataToCalulateAndSend(Integer elementIndex) {
		try{
			if(elementIndex == 1)
				return Integer.parseInt(txtFieldNum1.getText());
			else
				return Integer.parseInt(txtFieldNum2.getText());
		}catch (Exception e) {
			e.getStackTrace();
		}
		return 0;
	}

	private void doCalculateAndSendWithAdaptor(Integer num1, Integer num2) {
		if(cmbbxProcess.getValue().contains("+"))
			service.sendCalculateableText(num1, num2, Operation.ADDING);
		if(cmbbxProcess.getValue().contains("-"))
			service.sendCalculateableText(num1, num2, Operation.SUBTARCTING);
		if(cmbbxProcess.getValue().contains("*"))
			service.sendCalculateableText(num1, num2, Operation.MULTIPLYING);
		if(cmbbxProcess.getValue().contains("/"))
			service.sendCalculateableText(num1, num2, Operation.DIVIDING);
	}

	@FXML
    void sendLongMessage(ActionEvent event) {
		if(txtAreaLongMessage.getText().isEmpty())
			return;
		doSendingLongTextWithAdaptor();
		loadInMessageListAndResetFields();
    }

    private void doSendingLongTextWithAdaptor() {
		service.sendLongText(txtAreaLongMessage.getText());
	}

	@FXML
    void sendShortMessage(ActionEvent event) {
		if(txtFieldShortMessage.getText().isEmpty())
			return;
		doSendingShortTextWithAdaptor();
		loadInMessageListAndResetFields();
    }

	private void doSendingShortTextWithAdaptor() {
		service.sendShortText(txtFieldShortMessage.getText());
	}
	
	private void loadInMessageListAndResetFields(){
		listResult.setItems(service.getBackTheMessageResult());
		txtAreaLongMessage.setText("");
		txtFieldShortMessage.setText("");
		txtFieldNum1.setText("");
		txtFieldNum2.setText("");
		cmbbxProcess.getSelectionModel().clearSelection();
	}

	
}
