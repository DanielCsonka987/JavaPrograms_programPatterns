package application;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceObservingMessaging {
	
	private List<ObservedCompany> companies;
	private ObservableList<String> companyNames;
	private ObservableList<String> messagesOfCompany;
	
	public ServiceObservingMessaging() {
		super();
		
		companies = new ArrayList();
		loadInTestdatasToCompanies();
		companyNames = FXCollections.observableArrayList();
		messagesOfCompany = FXCollections.observableArrayList();
	}
	
	private void loadInTestdatasToCompanies(){
		companies.add(new ObservedCompany("Nokia"));
		companies.get(0).addNewPartner("Jeff");
		companies.get(0).addNewPartner("Amelia");
		companies.get(0).sendMessageToAllPartners("This is for test!");
		companies.add(new ObservedCompany("HP"));
		companies.add(new ObservedCompany("Maxtor"));
		companies.add(new ObservedCompany("Samsung"));
	}
	
	public ObservableList<String> getTheCompaniesList(){
		companyNames.clear();
		for(ObservedCompany oc : companies){
			companyNames.add(oc.getCompanyName());
		}
		return companyNames;
	}
	
	public void addNewCompany(String companyName){
		ObservedCompany comp = new ObservedCompany(companyName); 
		companies.add(comp);
	}
	
	public void removeThisCompany(String companyName){
		companies.removeIf((ObservedCompany x) ->
			x.getCompanyName().equals(companyName));
	}
	
	public ObservableList<String> getThisCompanyPartners(String companyName){
		return findThisCompany(companyName).collectAllPartners();
	}
	
	public void addPartnerToThisCompany(String companyName, String partnerName){
		findThisCompany(companyName).addNewPartner(partnerName);
	}
	
	public void removePartnerFromThisCompany(String companyName, String partnerName){
		findThisCompany(companyName).removeThisPartner(partnerName);
	}
	
	public ObservableList<String> getThisCompanyMessages(String companyName){
		return findThisCompany(companyName).collectAllMessages();
	}

	public void sendCollectivelyThisMessage(String companyName, String message){
		findThisCompany(companyName).sendMessageToAllPartners(message);
	}
	
	public void sendPrivatelyThisMessage(String companyName, String partnerName, String message){
		findThisCompany(companyName).sendMessageToChosenPartner(partnerName, message);
	}
	
	private ObservedCompany findThisCompany(String companyName){
		for(ObservedCompany oc : companies)
		{
			if(oc.getCompanyName().equals(companyName))
				return oc;
		}
		return null;
	}
}
