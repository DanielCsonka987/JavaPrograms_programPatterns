package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObserverPartner {

	private ObservedCompany itsCompany;
	private String nameOfPartner;
	private ObservableList<String> messages;
	
	public ObserverPartner(ObservedCompany itsCompany, String nameOfPartner) {
		super();
		this.itsCompany = itsCompany;
		this.nameOfPartner = nameOfPartner;
		messages = FXCollections.observableArrayList();
	}
	
	public String getNameOfPartner(){
		return nameOfPartner;
	}
	
	public void messageSending(String message){
		messages.add(itsCompany.getCompanyName() + "->" + nameOfPartner +  ": " + message);
		itsCompany.deliveringSuccess(nameOfPartner);
	}
	
	public ObservableList<String> getAllSentMessages(){
		return messages;
	}
}
