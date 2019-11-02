package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable {
	
	@FXML
	private Button btnPay;

	@FXML
	private Button btnEnter;

	@FXML
	private TextField txtBxFee;

	@FXML
	private Label lblResult;

	@FXML
	private Label lblPaymentStatus;

	@FXML
	void enterTheGate(ActionEvent event) {

	}

	@FXML
	void payTheFee(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
