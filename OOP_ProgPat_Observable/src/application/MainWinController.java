package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWinController implements Initializable {
	
    @FXML
    private ListView<String> listPartners;

    @FXML
    private ListView<String> listCompanies;

    @FXML
    private ListView<String> listMessages;

    @FXML
    private TextField txtNewAndManComp;

    @FXML
    private TextField txtNewAndManPart;

    @FXML
    private TextField txtNewMessage;
    
    @FXML
    private Button btnNewComp;

    @FXML
    private Button btnNewPart;

    @FXML
    private Button btnDelPart;

    @FXML
    private Button btnDelComp;

    @FXML
    private Button btnCollectMess;

    @FXML
    private Button btnPrivMess;

    private ServiceObservingMessaging service;
    private String managedCompanyName;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		service = new ServiceObservingMessaging();
		basicState_loadInCompaniesList();
		companyChanged_adjustBaseStateAppropiateTxtFiels();
	}

	private void companyChanged_adjustBaseStateAppropiateTxtFiels() {
		txtNewAndManPart.setText("");
		txtNewMessage.setText("");
		companyChanged_setPartnersAndMessages();
	}
	
	private void companyChanged_setPartnersAndMessages() {
		listPartners.itemsProperty();
		listMessages.itemsProperty();
	}
	
	
	private void basicState_loadInCompaniesList() {
		listCompanies.itemsProperty();
		managedCompanyName = listCompanies.getSelectionModel().getSelectedItem();
		txtNewAndManComp.setText(managedCompanyName);
	}
	
	
    
    
}
