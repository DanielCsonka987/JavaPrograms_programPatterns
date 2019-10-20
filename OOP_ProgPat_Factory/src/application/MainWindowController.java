package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable {

    @FXML
    private ComboBox<String> cmbbxChategory;

    @FXML
    private TextField txtFieldAuthor;

    @FXML
    private TextField txtFieldYear;

    @FXML
    private TextField txtFieldComicUniv;

    @FXML
    private Button btnAddNew;

    @FXML
    private ListView<String> listVolumes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
    
    @FXML
    void addingNewRecord(ActionEvent event) {

    }
}
