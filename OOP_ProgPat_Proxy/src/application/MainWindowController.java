package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class MainWindowController implements Initializable{

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
    private TableView<OrderingDatas> tableOrderings;
	
    @FXML
    private TableColumn<OrderingDatas, Number> colId;
    @FXML
    private TableColumn<OrderingDatas, String> colName;
    @FXML
    private TableColumn<OrderingDatas, String> colSize;
    @FXML
    private TableColumn<OrderingDatas, String> colColor;
    @FXML
    private TableColumn<OrderingDatas, Number> colAmount;
    
    private ServiceOrderingProxy dbProxy;
    private Integer orderingId = 1;
	private Integer amount;
	private ViewStates viewMode;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		defineAndAdjutTheTable();
		tableOrderings.itemsProperty().set(
				DataBaseLikeClass.getListOfOrderings());
		viewMode = ViewStates.NAME_STATE;
		adjustTheView();
	}

	private void defineAndAdjutTheTable() {
		colId = new TableColumn<OrderingDatas, Number>("ID");
		colId.setPrefWidth(30);
		colId.setCellValueFactory(x->x.getValue().getOrderId());
		colName = new TableColumn<OrderingDatas, String>("Name");
		colName.setPrefWidth(70);
		colName.setCellValueFactory(x->x.getValue().getClothesName());
		colSize = new TableColumn<OrderingDatas, String>("Size");
		colSize.setPrefWidth(40);
		colSize.setCellValueFactory(x->x.getValue().getClothesSize());
		colColor = new TableColumn<OrderingDatas, String>("Color");
		colColor.setPrefWidth(50);
		colColor.setCellValueFactory(x->x.getValue().getClothesColor());
		colAmount = new TableColumn<OrderingDatas, Number>("Amount");
		colAmount.setPrefWidth(60);
		colAmount.setCellValueFactory(x->x.getValue().getClothesAmount());
		tableOrderings.getColumns().addAll(colId, colName, colSize, colColor, colAmount);
	}
	
    private void adjustTheView() {
		if(viewMode == ViewStates.NAME_STATE){
			panelClothes.setVisible(true);
			paneSize.setVisible(false);
			panelColorPiece.setVisible(false);
		} else if(viewMode == ViewStates.SIZE_STATE){
			panelClothes.setVisible(false);
			paneSize.setVisible(true);
			panelColorPiece.setVisible(false);
		} else if (viewMode == ViewStates.COLOR_AMOUNT_STATE){
			panelClothes.setVisible(false);
			paneSize.setVisible(false);
			panelColorPiece.setVisible(true);
		} else {
			panelClothes.setVisible(false);
			paneSize.setVisible(false);
			panelColorPiece.setVisible(false);
			tableOrderings.itemsProperty().set(DataBaseLikeClass.getListOfOrderings());
		}
		
		if(dbProxy != null){
			txtFieldSum.setText(dbProxy.showCollectedDatas());
		}
	}
    
    @FXML
    void saveChosenClothes(ActionEvent event) {
    	if(reviseClothesName()){
    		dbProxy = new ServiceOrderingProxy(orderingId,
    				cmbBxClothes.getSelectionModel().getSelectedItem());
    		viewMode = ViewStates.SIZE_STATE;
    		adjustTheView();
    	}
    }

	private boolean reviseClothesName() {
		if(cmbBxClothes.getSelectionModel().isEmpty()){
			return false;
		}
		return true;
	}
	
    @FXML
    void saveChosenSize(ActionEvent event) {
    	if(reviseSizeIsSelected()){
    		RadioButton selRadBut = 
    				(RadioButton)sizeDefinition.getSelectedToggle();
    		dbProxy.addClothesSize(selRadBut.getText());
    		viewMode = ViewStates.COLOR_AMOUNT_STATE;
    		adjustTheView();
    	}
    }
	
    private Boolean reviseSizeIsSelected(){
    	if(sizeDefinition.getSelectedToggle() == null){
    		return false;
    	}
    	return true;
    }
    


	@FXML
    void saveChosenColorAndPeace(ActionEvent event) {
		if(reviseColorAndAount()){
			dbProxy.addClothesColor(cmbBxColor.getSelectionModel().getSelectedItem());
			dbProxy.addClothesAmount(amount);
	    	viewMode = ViewStates.REVISION_STATE;
	    	adjustTheView();
		}
    }

	private Boolean reviseColorAndAount(){
		if(cmbBxColor.getSelectionModel().isEmpty())
			return false;
		if(txtFieldAmount.getText().isEmpty())
			return false;

		try{
			amount = Integer.parseInt(txtFieldAmount.getText());
			return true;
		}catch(Exception e){
			e.getStackTrace();
			return false;
		}
	}
	
    @FXML
    void saveOrderedClothes(ActionEvent event) {
    	dbProxy.proxySaveOrderingContet();
    	orderingId++;
    	viewMode = ViewStates.NAME_STATE;
    	adjustTheView();
    	resetFieldsAndAreas();
    }


    
    @FXML
    void removeChosenClothes(ActionEvent event) {
    	if(viewMode != ViewStates.NAME_STATE){
    		dbProxy.proxyRemoveOrderingContent(orderingId);
    		viewMode = ViewStates.NAME_STATE;
			adjustTheView();
			resetFieldsAndAreas();
    	}
    }
    
	private void resetFieldsAndAreas(){
		if(! cmbBxClothes.getSelectionModel().isEmpty())
			cmbBxClothes.getSelectionModel().clearSelection();
		if(sizeDefinition.getSelectedToggle() != null)
			sizeDefinition.getSelectedToggle().setSelected(false);
		if(! cmbBxColor.getSelectionModel().isEmpty())
			cmbBxColor.getSelectionModel().clearSelection();
		txtFieldAmount.setText("");
		txtFieldSum.setText("");
	}

    private enum ViewStates{ NAME_STATE, SIZE_STATE, COLOR_AMOUNT_STATE, REVISION_STATE }
    
}
