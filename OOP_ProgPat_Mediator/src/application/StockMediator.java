package application;

import java.util.ArrayList;
import java.util.List;

public class StockMediator implements IMediator{

	
	private List<OfferingEntity> buyOffers;
	private List<OfferingEntity> sellOffers;
	private List<ColligueEntity> colligues;
	private List<OfferingMatch> matches;
	
	public StockMediator() {
		super();
		
		buyOffers = new ArrayList();
		sellOffers = new ArrayList();
		colligues = new ArrayList();
		matches = new ArrayList();
	}

	/*
	 * FOR COLLIGUE-OBJECT USE
	 * (non-Javadoc)
	 * @see application.IMediator#giveBuyOffer(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void giveBuyOffer(String colligue, String subj, Integer amount) {
		
		buyOffers.add(new OfferingEntity(colligue, subj, amount));
	}

	/*
	 * FOR COLLIGUE-OBJECT USE
	 * (non-Javadoc)
	 * @see application.IMediator#giveSellOffer(java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public void giveSellOffer(String colligue, String subj, Integer amount) {
		
		sellOffers.add(new OfferingEntity(colligue, subj, amount));
	}
	
	@Override
	public void addColligue(String colligueID) {
		
		colligues.add(new ColligueEntity(colligueID, this));
	}

	@Override
	public void doTheColligueActivity(String colligueID, ColligueActivity decide, String subj, Integer amount) {
		
		for(ColligueEntity ce : colligues){
			if(ce.getColligueId().equals(colligueID)){
				if(decide == ColligueActivity.OFFER_BUY)
					ce.shareBuyOffer(subj, amount);
				if(decide == ColligueActivity.OFFER_SELL)
					ce.shareSellOffer(subj, amount);
				break;
			}	
		}
		
		if(decide == ColligueActivity.OFFER_BUY)
			doTheMatchingWithSellings(colligueID, subj, amount);
		if(decide == ColligueActivity.OFFER_SELL)
			doTheMatchinWithBuys(colligueID, subj, amount);
	}
	
	
	private void doTheMatchingWithSellings(String buyerID, String subj, Integer amount) {
		
		for(OfferingEntity oe : sellOffers){
			if(oe.getOfferSubject().equals(subj) && oe.getOfferAmount() == amount){
				
				OfferingMatch newMatch = new OfferingMatch(
						buyerID, oe.getColligueID(), subj, amount);
				matches.add(newMatch);
			}
		}
	}

	private void doTheMatchinWithBuys(String sellerID, String subj, Integer amount) {
		
		for(OfferingEntity oe : buyOffers){
			if(oe.getOfferSubject().equals(subj) && oe.getOfferAmount() == amount){
				
				OfferingMatch newMatch = new OfferingMatch(
						oe.getColligueID(), sellerID, subj, amount);
				matches.add(newMatch);
			}
		}
	}

	@Override
	public List<String> getSumBuyOfferings() {
		
		List<String> temp = new ArrayList();
		for(OfferingEntity oe : buyOffers){
			String row = oe.getColligueID() + " = "
					+ oe.getOfferSubject() + " " + oe.getOfferAmount();
			temp.add(row);
		}
		return temp;
	}

	@Override
	public List<String> getSumSellOferings() {
		
		List<String> temp = new ArrayList();
		for(OfferingEntity oe : sellOffers){
			String row = oe.getColligueID() + " = "
					+ oe.getOfferSubject() + " " + oe.getOfferAmount();
			temp.add(row);
		}
		return temp;
	}

	@Override
	public List<String> getSumMatches() {
		
		List<String> temp = new ArrayList();
		
		for(OfferingMatch om : matches){
			String row = "S:" + om.getSellCode() + "->" + "B:" + om.getBuyCode() + "="
					+ om.getSubject() + " " + om.getAmount();
			temp.add(row);
		}
		return temp;
	}

	@Override
	public List<String> getAllColligues(){
		
		List<String> temp = new ArrayList();
		
		for(ColligueEntity ce : colligues){
			temp.add(ce.getColligueId());
		}
		return temp;
	}

}
