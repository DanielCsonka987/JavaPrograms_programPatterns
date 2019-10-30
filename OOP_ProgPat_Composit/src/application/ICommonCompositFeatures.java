package application;

import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public interface ICommonCompositFeatures {
	
	ObservableList<String> getTitleTextOfNodes_ToCombobox();
	
	TreeItem getTitleText_ToView();
	
}
