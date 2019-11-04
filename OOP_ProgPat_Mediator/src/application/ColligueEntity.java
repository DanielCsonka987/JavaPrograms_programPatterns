package application;

import java.util.HashMap;
import java.util.Map;

public class ColligueEntity implements IColligue{

	private String colligueID;
	private StockMediator med;
	
	public ColligueEntity(String colligueID, StockMediator med) {
		super();
		this.colligueID = colligueID;
		this.med = med;

	}

	@Override
	public String getColligueId() {

		return colligueID;
	}

	@Override
	public void shareBuyOffer(String subj, Integer amount) {
		
		med.giveBuyOffer(colligueID, subj, amount);
	}

	@Override
	public void shareSellOffer(String subj, Integer amount) {
		
		med.giveSellOffer(colligueID, subj, amount);
	}



}
