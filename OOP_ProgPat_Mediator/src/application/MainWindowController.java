package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private ListView<?> lstvwSellings;

    @FXML
    private ListView<?> lstvwBuyings;

    @FXML
    private ListView<?> lstvwMatches;

    @FXML
    void addColleague(ActionEvent event) {

    }

    @FXML
    void offerBuy(ActionEvent event) {

    }

    @FXML
    void offerSell(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
