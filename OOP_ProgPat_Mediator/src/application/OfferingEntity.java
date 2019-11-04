package application;

public class OfferingEntity {

	private String colligueID;
	private String offerSubject;
	private Integer offerAmount;
	
	public OfferingEntity(String colligueID, String offerSubject, Integer offerAmount) {
		super();
		this.colligueID = colligueID;
		this.offerSubject = offerSubject;
		this.offerAmount = offerAmount;
	}

	public String getColligueID() {
		return colligueID;
	}

	public String getOfferSubject() {
		return offerSubject;
	}

	public Integer getOfferAmount() {
		return offerAmount;
	}
	
	
}
