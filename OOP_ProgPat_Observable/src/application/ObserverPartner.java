package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObserverPartner implements IObserver {

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
	
	@Override
	public void messageSending(String message){
		messages.add(itsCompany.getCompanyName() + "->" + nameOfPartner +  ": " + message);
		itsCompany.deliveringSuccessFeedback(nameOfPartner);
	}
	
	public ObservableList<String> getAllSentMessages(){
		return messages;
	}
}
