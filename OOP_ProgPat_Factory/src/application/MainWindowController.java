package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.BookShopFactory.VolumeChategories;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable {

    @FXML
    private ComboBox<String> cmbbxChategory;

    @FXML
    private TextField txtFieldTitle;

    @FXML
    private TextField txtFieldYear;

    @FXML
    private TextField txtFieldComicUniv;

    @FXML
    private Button btnAddNew;
    
    @FXML
    private Label lblVolumeTitle;
    
    @FXML
    private ListView<String> listViewOfRecords;
    private ObservableList<String> list;
    private ObservableList<IVolume> listOfVolumes;
    private BookShopFactory volumeFactory;
    private VolumeChategories modeOfWindow;
    private Integer yearValue;
    private String[] dataValues;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listOfVolumes = FXCollections.observableArrayList();
		list = FXCollections.observableArrayList();
		loadInTestDatas();
		volumeFactory = new BookShopFactory();
		resetFieldsAndUpdateList();
	}
	
    private void loadInTestDatas() {
    	IVolume testPiece = new VolumeBook(0, "Anna Karerina", 1890);
		listOfVolumes.add(testPiece);
		list.add(testPiece.toString());
	}
    
	private void resetFieldsAndUpdateList(){
		listViewOfRecords.itemsProperty().set(list);
		cmbbxChategory.getSelectionModel().clearSelection();
		txtFieldTitle.setText("");
		txtFieldYear.setText("");
		txtFieldComicUniv.setText("");
	}

	@FXML
    void addingNewRecord(ActionEvent event) {
    	if(reviseAllFieldsFilled()){
    		collectDatasToVariables();
    		IVolume newOne = volumeFactory.setTheNewVolume(dataValues, yearValue, modeOfWindow);
    		listOfVolumes.add(newOne);
    		list.add(newOne.toString());
    		resetFieldsAndUpdateList();
    	}
    }
    
	private boolean reviseAllFieldsFilled() {

    	if(cmbbxChategory.getSelectionModel().selectedIndexProperty().get() == -1)
    		return false;
		if(txtFieldTitle.getText().isEmpty())
			return false;
		if(txtFieldYear.getText().isEmpty())
			return false;

		if(modeOfWindow == VolumeChategories.COMIC && txtFieldComicUniv.getText().isEmpty())
			return false;
		return true;
	}

    private void collectDatasToVariables() {
		dataValues = new String[2];
		try{
			yearValue = Integer.parseInt(txtFieldYear.getText());
			dataValues[0] = txtFieldTitle.getText();
			if(modeOfWindow == VolumeChategories.COMIC)
				dataValues[1] = txtFieldComicUniv.getText(); 
		}catch(Exception e){
			e.getStackTrace();
		}
	}

	
	@FXML
    void chategorySelectionChanged(ActionEvent event) {
		if(cmbbxChategory.getSelectionModel().getSelectedIndex() != -1){
			if(cmbbxChategory.getSelectionModel().getSelectedItem().equals("Book"))
				disableComicUniversElements();
			else
				enableComicUniverseElements();
		}
    }

	private void enableComicUniverseElements() {
		lblVolumeTitle.visibleProperty().set(true);
		txtFieldComicUniv.visibleProperty().set(true);
		modeOfWindow = VolumeChategories.COMIC;
	}

	private void disableComicUniversElements() {
		lblVolumeTitle.visibleProperty().set(false);
		txtFieldComicUniv.visibleProperty().set(false);
		modeOfWindow = VolumeChategories.BOOK;
	}
}
