package application;

import java.util.List;

public interface IMediator {

	void giveBuyOffer(String colligue, String subj, Integer amount);
	void giveSellOffer(String colligue, String subj, Integer amount);
	
	void addColligue(String colligueID);
	void doTheColligueActivity(String colligueID, ColligueActivity decide,
			String subj, Integer amount );
	
	List<String> getSumBuyOfferings();
	List<String> getSumSellOferings();
	List<String> getSumMatches();
	
	List<String> getAllColligues();
}
