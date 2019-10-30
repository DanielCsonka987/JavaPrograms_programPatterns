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

	
	public void addNewItemToList(ICommonCompositFeatures eNew, String whereToDo){
		if(whereToDo.equals(titleOfNode)){
				listOfElements.add(eNew);
		}
		else{
			for(ICommonCompositFeatures element : listOfElements){
				if(element instanceof CompositNode){
					CompositNode temp = (CompositNode)element;
					if(temp.seekedNodeIsInThisNode(whereToDo) || temp.getName().equals(whereToDo)){
						temp.addNewItemToList(eNew, whereToDo);

					}
					else
						continue;
				}
			}
		}
	}
	
	public void removeItemFromList(String eExist, String whereToDo){
		if(whereToDo.equals(titleOfNode)){
			ICommonCompositFeatures temp = null;
			for (ICommonCompositFeatures e : listOfElements) {
				if (e.getName().equals(eExist)) {
					temp = e;
					break;
				}
			}
			listOfElements.remove(temp);
		}
		else{
			for(ICommonCompositFeatures element : listOfElements){
				if(element instanceof CompositNode){
					CompositNode temp = (CompositNode)element;
					if(temp.seekedNodeIsInThisNode(whereToDo) || temp.getName().equals(whereToDo)){
						temp.removeItemFromList(eExist, whereToDo);
					}
					else
						continue;
				}
			}
		}
	}
	
	public Boolean seekedNodeIsInThisNode(String whereTo){
		for(ICommonCompositFeatures element : listOfElements){
			if(element instanceof CompositNode){
				CompositNode temp = (CompositNode)element;
				if(temp.getName().equals(whereTo))
					return true;
				if(temp.seekedNodeIsInThisNode(whereTo))
					return true;
				else
					continue;
			}
		}
		return false;
	}

}
