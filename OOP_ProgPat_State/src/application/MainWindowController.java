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

	private BehaveOfGate logic;
	private Integer payment;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		logic = new BehaveOfGate();
		lblResult.setStyle("-fx-text-fill: red;");
		lblPaymentStatus.setText(logic.getThePaymentLabel());
		lblResult.setText(logic.getTheGateStateLabel());
		
	}
	
	@FXML
	void enterTheGate(ActionEvent event) {
		
		attemptEnter();
		lblPaymentStatus.setText(logic.getThePaymentLabel());
		lblResult.setText(logic.getTheGateStateLabel());
	}
	
	private void attemptEnter(){
		
		if(logic.entrTheGate()){
			lblResult.setStyle("-fx-text-fill: red;");
		} else {
			lblResult.setStyle("-fx-text-fill: green;");
		}
	}
	
	@FXML
	void payTheFee(ActionEvent event) {
		
		if(reviseTheProblems())
			return;
		if(logic.payThePrice(payment)){
			txtBxFee.setText("");
			lblResult.setStyle("-fx-text-fill: green;");
		}
		lblPaymentStatus.setText(logic.getThePaymentLabel());
		lblResult.setText(logic.getTheGateStateLabel());
	}


	private Boolean reviseTheProblems(){
		
		if(txtBxFee.getText().equals(""))
			return true;
		try{
			payment = Integer.parseInt(txtBxFee.getText());
			return false;
		}catch(Exception e){
			e.getStackTrace();
			return true;
		}
	}


	
}
