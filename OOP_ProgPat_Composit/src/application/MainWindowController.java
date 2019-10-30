package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class MainWindowController implements Initializable {


    @FXML
    private TreeView<?> trvwElements;

    @FXML
    private ComboBox<String> cmbBxListOfNodes;

    @FXML
    private TextField txtFieldTitle;

    @FXML
    private CheckBox chckBxNodeIndic;

    @FXML
    private Button btnAddNewElement;

    @FXML
    private Button btnRemoveElement;
	
    private List<ICommonCompositFeatures> listOfTreeElements;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		listOfTreeElements = new ArrayList();
		loadInTestDatasToList();
		reloadTreeViewContent();
	}
	
	private void loadInTestDatasToList() {
		
		CompositLeaf l1 = new CompositLeaf("Leaf 1");
		CompositLeaf l2 = new CompositLeaf("Leaf 2");
		CompositNode n1 = new CompositNode("Node1");
		n1.addNewItemToList(l1);
		n1.addNewItemToList(l2);
		listOfTreeElements.add(n1);
		
	}

	private void reloadTreeViewContent(){
		
		TreeItem rootElement = new TreeItem<String>("Root");
		for (ICommonCompositFeatures e : listOfTreeElements){
			rootElement.getChildren().add(e.getTitleText_ToView());
		}
		trvwElements.setRoot(rootElement);
	}
	
    @FXML
    void addNewElement(ActionEvent event) {

    }

    @FXML
    void removeElement(ActionEvent event) {

    }


	
}
