package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainWindowController {
	 @FXML
	    private TableView<?> tableEmployee;

	    @FXML
	    private TextField txtFieldName1;

	    @FXML
	    private Button btnAddOne;

	    @FXML
	    private Button btnAddTwo;

	    @FXML
	    private ComboBox<?> cmbbxPosit;

	    @FXML
	    private ComboBox<?> cmbbxArea;

	    @FXML
	    private TextField txtFieldName2;

	    @FXML
	    private ComboBox<?> cmbbxGender;

	    @FXML
	    private TextField txtFieldBirth;

	    @FXML
	    void saveFirstFormContent(ActionEvent event) {

	    }

	    @FXML
	    void saveSecondFromContent(ActionEvent event) {

	    }
}
