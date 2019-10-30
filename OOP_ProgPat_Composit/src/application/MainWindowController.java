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
    private TreeView<String> trvwElements;

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
	
    private CompositNode rootOfTreeElement;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		rootOfTreeElement = new CompositNode("Root");
		loadInTestDatasToList();
		reloadTreeViewContent();
	}
	
	private void loadInTestDatasToList() {
		
		CompositLeaf l1 = new CompositLeaf("Leaf 1");
		CompositLeaf l2 = new CompositLeaf("Leaf 2");
		CompositNode n1 = new CompositNode("Node1");
		n1.addNewItemToList(l1, "Node: Node1");
		n1.addNewItemToList(l2, "Node: Node1");
		rootOfTreeElement.addNewItemToList(n1, "Node: Root");
		
	}

	private void reloadTreeViewContent(){
		
		TreeItem rootElement = new TreeItem<String>("Root");
		trvwElements.setRoot(rootOfTreeElement.getTitleText_ToView());
	}
	
    @FXML
    void addNewElement(ActionEvent event) {
    	
    	if(reviseFieldsAreFilled_BeforeAdd())
    		return;
    	String elementName = txtFieldTitle.getText();
    	TreeItem targerNode = trvwElements.getSelectionModel().getSelectedItem();
    	
    	ICommonCompositFeatures element = null;
    	if(chckBxNodeIndic.isSelected()){
    		element = new CompositNode(elementName);
    	}else{
    		element = new CompositLeaf(elementName);
    	}
    	
    	rootOfTreeElement.addNewItemToList(element, targerNode.getValue().toString());
    	reloadTreeViewContent();
    	clearFieldAfterProcess();
    }

    @FXML
    void removeElement(ActionEvent event) {
    	if(reviseFieldsAreFilled_BeforeRemove())
    		return;
    	
    	TreeItem parentTargerNodeName = trvwElements.getSelectionModel().getSelectedItem().getParent();
    	TreeItem targetToDeleteNode = trvwElements.getSelectionModel().getSelectedItem();
    	
    	rootOfTreeElement.removeItemFromList(targetToDeleteNode.getValue().toString(),
    			parentTargerNodeName.getValue().toString());
    	reloadTreeViewContent();
    	clearFieldAfterProcess();
    }

    private Boolean reviseFieldsAreFilled_BeforeAdd(){
    	if(txtFieldTitle.getText().equals(""))
    		return true;
    	if(trvwElements.getSelectionModel().isEmpty())
    		return true;
    	return false;
    }
	
    private Boolean reviseFieldsAreFilled_BeforeRemove(){
    	if(trvwElements.getSelectionModel().isEmpty())
    		return true;
    	if(trvwElements.getSelectionModel().getSelectedItem().getValue().toString().equals("Node: Root"))
    		return true;
    	return false;
    }
    
    private void clearFieldAfterProcess(){
    	txtFieldTitle.setText("");
    	chckBxNodeIndic.setSelected(false);
    }
    
}
