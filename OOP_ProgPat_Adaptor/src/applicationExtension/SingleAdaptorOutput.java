package applicationExtension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SingleAdaptorOutput implements IAdaptorOutput{
	private static ObservableList<String> listOfMessages = FXCollections.observableArrayList();

	public static void sendTheMessageToAddresse(String finalMessage) {
		listOfMessages.add(finalMessage);
	}
	
	public static ObservableList<String> getTheMessages(){
		return listOfMessages;
	}




	
}
