package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class MainWindowController {

    @FXML
    private AnchorPane paneSize;

    @FXML
    private ToggleGroup sizeDefinition;

    @FXML
    private Button btnSize;

    @FXML
    private AnchorPane panelClothes;

    @FXML
    private Button btnClothes;

    @FXML
    private ComboBox<String> cmbBxClothes;

    @FXML
    private AnchorPane panelColorPiece;

    @FXML
    private Button btnColorPiece;

    @FXML
    private ComboBox<String> cmbBxColor;

    @FXML
    private TextField txtFieldAmount;

    @FXML
    private AnchorPane panelReview;

    @FXML
    private Button btnRemoving;

    @FXML
    private Button btnOrdering;

    @FXML
    private TextField txtFieldSum;

    @FXML
    void removeChosenClothes(ActionEvent event) {

    }

    @FXML
    void saveChosenClothes(ActionEvent event) {

    }

    @FXML
    void saveChosenColorAndPeace(ActionEvent event) {

    }

    @FXML
    void saveChosenSize(ActionEvent event) {

    }

    @FXML
    void saveOrderedClothes(ActionEvent event) {

    }
}
