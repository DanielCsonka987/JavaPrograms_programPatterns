package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable{

    @FXML
    private TextField txtOfferSell;

    @FXML
    private TextField txtOfferSellAm;

    @FXML
    private TextField txtOfferBuy;

    @FXML
    private TextField txtOfferBusAm;

    @FXML
    private TextField txtColleague;

    @FXML
    private ListView<String> lstvwSellings;

    @FXML
    private ListView<String> lstvwBuyings;

    @FXML
    private ListView<String> lstvwMatches;

    @FXML
    private ComboBox<String> cmbBxActColligue;

    private StockMediator mediator;
    private String actManager;
    private Integer actAmount;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		mediator = new StockMediator();
		loadInTestDatas();
		loadInDatasToList();
		loadInColligues();
	}

	private void loadInTestDatas() {
		
		mediator.addColligue("Johnson");
		mediator.addColligue("Clausmann");
		mediator.doTheColligueActivity(
				"Johnson", ColligueActivity.OFFER_BUY,
				"Microsft", 110);
		mediator.doTheColligueActivity(
				"Clausmann", ColligueActivity.OFFER_SELL,
				"Microsft", 110);
		mediator.doTheColligueActivity(
				"Johnson", ColligueActivity.OFFER_BUY,
				"HP", 23);
		mediator.doTheColligueActivity(
				"Clausmann", ColligueActivity.OFFER_BUY,
				"WD", 234);
	}
	
    private void loadInDatasToList() {
    	
    	lstvwBuyings.getItems().clear();
		lstvwBuyings.getItems().addAll(mediator.getSumBuyOfferings());
		
		lstvwSellings.getItems().clear();
		lstvwSellings.getItems().addAll(mediator.getSumSellOferings());
		
		lstvwMatches.getItems().clear();
		lstvwMatches.getItems().addAll(mediator.getSumMatches());
	}
    
	private void loadInColligues(){
		
    	cmbBxActColligue.getItems().clear();
    	cmbBxActColligue.getItems().addAll(mediator.getAllColligues());
	}
    
	@FXML
    void addColleague(ActionEvent event) {
		
		if(txtColleague.getText().isEmpty())
			return;
		mediator.addColligue(txtColleague.getText());
		
		actManager = txtColleague.getText();
		cmbBxActColligue.getSelectionModel().select(actManager);
		
		loadInColligues();
		txtColleague.setText("");
    }


	
    @FXML
    void changedManagerColligue(ActionEvent event) {

    	if(cmbBxActColligue.getSelectionModel().isEmpty())
    		return;
    	
    	actManager = cmbBxActColligue.getSelectionModel().getSelectedItem();
    }
	
    @FXML
    void offerBuy(ActionEvent event) {

    	if(reviseBuyerField())
    		return;
    	
    	mediator.doTheColligueActivity(actManager, ColligueActivity.OFFER_BUY,
    			txtOfferBuy.getText(), actAmount);
    	
    	loadInDatasToList();
    	clearBuyFields();
    }
	


	private Boolean reviseBuyerField(){
		
		if(cmbBxActColligue.getSelectionModel().isEmpty())
			return true;
		if(txtOfferBuy.getText().isEmpty())
			return true;
		if(txtOfferBusAm.getText().isEmpty())
			return true;
		
		try{
			actAmount = Integer.parseInt(txtOfferBusAm.getText());
		}catch (Exception e){
			e.getStackTrace();
			return true;
		}
		
		return false;
	}
    
	private void clearBuyFields() {
		
		txtOfferBuy.setText("");
		txtOfferBusAm.setText("");
	}
	
    @FXML
    void offerSell(ActionEvent event) {

    	if(reviseSellerField())
    		return;
    	
    	mediator.doTheColligueActivity(actManager, ColligueActivity.OFFER_SELL,
    			txtOfferSell.getText(), actAmount);
    	
    	loadInDatasToList();
    	clearSellerField();
    }


	private Boolean reviseSellerField(){
		
		if(cmbBxActColligue.getSelectionModel().isEmpty())
			return true;
		if(txtOfferSell.getText().isEmpty())
			return true;
		if(txtOfferSellAm.getText().isEmpty())
			return true;
		
		try{
			actAmount = Integer.parseInt(txtOfferSellAm.getText());
		}catch (Exception e){
			e.getStackTrace();
			return true;
		}
		
		return false;
	}
	
	private void clearSellerField(){
		
		txtOfferSell.setText("");
		txtOfferSellAm.setText("");
	}
    
}
