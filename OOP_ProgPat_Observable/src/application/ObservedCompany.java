package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservedCompany {
	private String nameOfCompany;
	private ObservableList<ObserverPartner> partners;
	private ObservableList<String> sentMessages;
	
	
	public ObservedCompany(String companyName) {
		super();
		this.nameOfCompany = companyName;
		
		partners = FXCollections.observableArrayList();
		sentMessages = FXCollections.observableArrayList();
	}
	
	public void addNewPartner(String partnerName){
		ObserverPartner p = new ObserverPartner(this, partnerName);
		partners.add(p);
	}
	
	public void removeThisPartner(String partnerName){
		partners.removeIf( x->x.getNameOfPartner() == partnerName);
	}
	
	public String getCompanyName(){
		return nameOfCompany;
	}
	
	public void sendMessageToAllPartners(String message){
		partners.forEach((x) -> {
			x.messageSending(message);
		});
	}
	
	public void sendMessageToChosenPartner(String partnerName, String message){
		for(ObserverPartner op : partners){
			if(op.getNameOfPartner() == partnerName)
				op.messageSending(message);
		}
	}
	
	public void deliveringSuccess(String partnerName){
		System.out.println("Sending completed to " + partnerName + " at " + nameOfCompany );
	}
	
	public ObservableList<String> collectAllPartners(){
		ObservableList<String> partList = FXCollections.observableArrayList();
		for(ObserverPartner op : partners){
			partList.add(op.getNameOfPartner());
		}
		return partList;
	}

	public ObservableList<String> collectAllMessages(){
		sentMessages = FXCollections.observableArrayList(); 
		partners.forEach((x) ->{
			sentMessages.addAll(x.getAllSentMessages());
		});
		return sentMessages;
	}

	
}
