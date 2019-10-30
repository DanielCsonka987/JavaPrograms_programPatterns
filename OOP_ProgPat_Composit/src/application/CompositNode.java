package application;

import java.util.HashSet;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class CompositNode implements ICommonCompositFeatures {
	
	private String titleOfNode;
	private Set<ICommonCompositFeatures> listOfElements;
	
	public CompositNode(String titleOfNode) {
		super();
		this.titleOfNode = "Node: " + titleOfNode;
		listOfElements = new HashSet();
	}

	@Override
	public String getName(){
		return titleOfNode;
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

	private Set<String> collectAllNodeNames() {
		
		Set<String> temp = new HashSet<String>();
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

	
	public Boolean addNewItemToList(ICommonCompositFeatures eNew, String whereToDo){
		
		if(whereToDo.equals(titleOfNode)){
			return listOfElements.add(eNew);
		}
		else{
			return addTheNewElementToSublevels(eNew, whereToDo);
		}
	}
	
	private Boolean addTheNewElementToSublevels(ICommonCompositFeatures eNew, String whereToDo){
		
		for(ICommonCompositFeatures element : listOfElements){
			if(element instanceof CompositNode){
				CompositNode temp = (CompositNode)element;
				if(temp.addNewItemToList(eNew, whereToDo))
					return true;
				}
				else
					continue;
		}
		return false;
	}
	
	
	public Boolean removeItemFromList(String eNameToRemove, String whereToDo){
		
		if(whereToDo.equals(titleOfNode)){
			return doTheRemovingHere(eNameToRemove);
		}
		else{
			return doTheRemovingAboveLevels(eNameToRemove, whereToDo);
		}
	}
	
	private Boolean doTheRemovingHere(String eNameToRemove){
		
		ICommonCompositFeatures temp = null;
		for (ICommonCompositFeatures e : listOfElements) {
			if (e.getName().equals(eNameToRemove)) {
				temp = e;
				break;
			}
		}
		return listOfElements.remove(temp);
	}
	
	private Boolean doTheRemovingAboveLevels(String eNameToRemove, String whereToDo){
		
		for(ICommonCompositFeatures element : listOfElements){
			if(element instanceof CompositNode){
				CompositNode temp = (CompositNode)element;
				if(temp.removeItemFromList(eNameToRemove, whereToDo)){
					return true;
				} else
					continue;
			}
		}
		return false;
	}
}
