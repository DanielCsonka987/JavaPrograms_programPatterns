package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    private String managedPartnerName;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		service = new ServiceObservingMessaging();
		basicStateOrCompanyListChanged_loadInCompaniesList_ResetTextFields();
	}

	
	private void basicStateOrCompanyListChanged_loadInCompaniesList_ResetTextFields() {
		listCompanies.itemsProperty().set(service.getTheCompaniesList());
		listPartners.getItems().clear();
		listMessages.getItems().clear();
		managedCompanyName = "";
		txtNewAndManComp.setText("");
		txtNewAndManPart.setText("");
		txtNewMessage.setText("");
	}

    @FXML
    void companySelected(MouseEvent event) {
    	aListChanged_setPartnersAndMessages();
    }
    
    @FXML
    void addNewCompany(ActionEvent event) {
    	if(txtNewAndManComp.getText().isEmpty())
    		return;
    	addNewCompany();
    	basicStateOrCompanyListChanged_loadInCompaniesList_ResetTextFields();
    }
    
    @FXML
    void removeTheCompany(ActionEvent event) {
    	if(listCompanies.getSelectionModel().isEmpty())
    		return;
    	removeChosenCompany();
    	basicStateOrCompanyListChanged_loadInCompaniesList_ResetTextFields();
    }
    
	private void aListChanged_setPartnersAndMessages() {
		managedCompanyName = listCompanies.getSelectionModel().getSelectedItem();
		listPartners.itemsProperty().set(service.getThisCompanyPartners(managedCompanyName));
		listMessages.itemsProperty().set(service.getThisCompanyMessages(managedCompanyName));
		txtNewAndManPart.setText("");
		txtNewMessage.setText("");
	}

	private void addNewCompany(){
		managedCompanyName = txtNewAndManComp.getText();
		service.addNewCompany(managedCompanyName);
	}
    
	private void removeChosenCompany(){
		service.removeThisCompany(managedCompanyName);
	}
	
    @FXML
    void partnerSelected(MouseEvent event) {
    	partnerChanged_setDetailsToManage();
    }

    @FXML
    void addNewPartner(ActionEvent event) {
    	if(txtNewAndManPart.getText().isEmpty())
    		return;
    	partnerManage_addNew();
    	aListChanged_setPartnersAndMessages();
    }

    @FXML
    void removeThePartner(ActionEvent event) {
    	if(listPartners.getSelectionModel().isEmpty())
    		return;
    	partnerManage_removeChosen();
    	aListChanged_setPartnersAndMessages();
    }
	
	private void partnerChanged_setDetailsToManage(){
		managedPartnerName = listPartners.getSelectionModel().getSelectedItem();
	}
	
	private void partnerManage_addNew(){
		managedPartnerName = txtNewAndManPart.getText();
		service.addPartnerToThisCompany(managedCompanyName, managedPartnerName);
	}
	
	private void partnerManage_removeChosen(){
		service.removePartnerFromThisCompany(managedCompanyName, managedPartnerName);
	}

    @FXML
    void sendCollectiveMessage(ActionEvent event) {
    	if(txtNewMessage.getText().isEmpty())
    		return;
    	if(listCompanies.getSelectionModel().isEmpty())
    		return;
    	sendingCollectivelyText();
    	aListChanged_setPartnersAndMessages();
    }

    @FXML
    void sendPrivateMessage(ActionEvent event) {
    	if(txtNewMessage.getText().isEmpty())
    		return;
    	if(listPartners.getSelectionModel().isEmpty())
    		return;
    	sendingPrivateText();
    	aListChanged_setPartnersAndMessages();
    }
    
    private void sendingCollectivelyText(){
    	String theMessage = txtNewMessage.getText();
    	service.sendCollectivelyThisMessage(managedCompanyName, theMessage);
    }
    
    private void sendingPrivateText(){
    	String theMessage = txtNewMessage.getText();
    	service.sendPrivatelyThisMessage(managedCompanyName, managedPartnerName, theMessage);
    }
}
