package application;

public interface IColligue {

	String getColligueId();
	
	void shareBuyOffer(String subj, Integer amount);
	void shareSellOffer(String subj, Integer amount);
	
}
