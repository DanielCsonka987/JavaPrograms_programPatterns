package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class CompositLeaf implements ICommonCompositFeatures{

	private String titleOfText;
	
	
	public CompositLeaf(String titleOfText) {
		super();
		this.titleOfText = titleOfText;
	}

	@Override
	public ObservableList<String> getTitleTextOfNodes_ToCombobox() {
		ObservableList<String> title = FXCollections.observableArrayList();
		return title;
	}

	@Override
	public TreeItem getTitleText_ToView() {
		TreeItem leaf = new TreeItem<String>(titleOfText);
		return leaf;
	}

}
