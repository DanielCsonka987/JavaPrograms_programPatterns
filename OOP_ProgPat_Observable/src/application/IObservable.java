package application;

public interface IObservable {

	void addNewPartner(String partnerName);
	void removeThisPartner(String partnerName);
	
	void sendMessageToAllPartners(String message);
	void sendMessageToChosenPartner(String partnerName, String message);
	
	void deliveringSuccessFeedback(String partnerName);
}
