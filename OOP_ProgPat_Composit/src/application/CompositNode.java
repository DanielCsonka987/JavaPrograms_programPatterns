package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class CompositNode implements ICommonCompositFeatures {
	
	private String titleOfNode;
	private List<ICommonCompositFeatures> listOfElements;
	
	public CompositNode(String titleOfNode) {
		super();
		this.titleOfNode = titleOfNode;
	}

	@Override
	public ObservableList<String> getTitleTextOfNodes_ToCombobox() {
		
		ObservableList<String> nodeElements = FXCollections.observableArrayList();
		nodeElements.add(titleOfNode);
		if(listOfElements == null){ 
			return nodeElements;
		}
		if(isThereNodeIntTheElements()){
			return nodeElements;
		}
		nodeElements.addAll(collectAllNodeNames());
		return nodeElements;
	}

	private Boolean isThereNodeIntTheElements(){
		for(ICommonCompositFeatures e : listOfElements){
			if(e instanceof CompositNode)
				return true;
		}
		return false;
	}

	private List<String> collectAllNodeNames() {
		
		List<String> temp = new ArrayList<String>();
		for(ICommonCompositFeatures e : listOfElements){
			if(e instanceof CompositNode)
				temp.addAll(e.getTitleTextOfNodes_ToCombobox());
		}
		return temp;
	}

	@Override
	public TreeItem getTitleText_ToView() {
		TreeItem nodeContent = new TreeItem<String>(titleOfNode);
		if(listOfElements.size() > 0){
			for(ICommonCompositFeatures e : listOfElements){
				nodeContent.getChildren().add(e.getTitleText_ToView());
			}
		}
		return nodeContent;
	}

}
