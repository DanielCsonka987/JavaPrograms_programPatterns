package application;

import javafx.collections.ObservableList;

public class DataBaseInterfaceLikeClass {

	private static DataBaseInterfaceLikeClass singletonInstance;
	private static DataBaseLikeClass dbObject;
	
	private DataBaseInterfaceLikeClass(){
		loadInTestData();
	}
	
	private void loadInTestData(){
		dbObject = new DataBaseLikeClass();
		dbObject.saveMessage("This is a text for testing");
	}
	
	public static DataBaseInterfaceLikeClass getSingletonInterface(){
		if(singletonInstance == null){
			singletonInstance = new DataBaseInterfaceLikeClass();
		}
		return singletonInstance;
	}
	
	public void addNewMessageToDB(String message) {
		dbObject.saveMessage(message);
	}
	
	public ObservableList<String> loadInMessagesFromDB(){
		return dbObject.loadInMessages();
	}
}
