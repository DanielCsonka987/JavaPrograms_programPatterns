package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.Caret;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class MainWindowController implements Initializable {

    @FXML
    private TextArea txtAreaText;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnRedo;

    private TextCaretaker cont;
    private TextOriginator orig;
    private Integer textIndexer;
    private Integer savedFiles;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		txtAreaText.setWrapText(true);
		cont = new TextCaretaker();
		orig = new TextOriginator();
		orig.setSavedText("");
		cont.addNewMemento(orig.storeNewTextMemento());
		textIndexer = 0;
		savedFiles = 1;
	}
    


    @FXML
    void saveText(ActionEvent event) {
    	
    	if(txtAreaText.getText().equals(""))
    		return;
    	orig.setSavedText(txtAreaText.getText());
    	cont.addNewMemento(orig.storeNewTextMemento());
    	textIndexer++;
    	savedFiles++;
    }

    @FXML
    void undoText(ActionEvent event) {
    	
    	if(textIndexer >= 1){
    		textIndexer--;
			txtAreaText.setText(orig.restoreTextMemento(cont.getMemento(textIndexer)));
		}
    }

    @FXML
    void redoText(ActionEvent event) {

    	if(textIndexer < savedFiles){
    		textIndexer++;
    		if(textIndexer == savedFiles)
    			textIndexer--;
    		txtAreaText.setText(
    				orig.restoreTextMemento(cont.getMemento(textIndexer))
    				);
    	}
    }
    
    @FXML
    void removeText(ActionEvent event){
    	
    	if(textIndexer < savedFiles && textIndexer >= 1){
    		if(cont.remveMementi(orig.removeTextMementi(textIndexer))){
    			savedFiles--;
    		}
    	}
    	
    }
    
}
