package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBaseLikeClass {

	private static ObservableList<String> listOfMessages = FXCollections.observableArrayList();
	
	public static void saveMessage(String message){
		listOfMessages.add(message);
	}
	
	public static ObservableList<String> loadInMessages(){
		return listOfMessages;
	}
}
