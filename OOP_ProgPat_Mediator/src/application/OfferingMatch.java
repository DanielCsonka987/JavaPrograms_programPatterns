package application;

public class OfferingMatch {

	private String buyCode;
	private String sellCode;
	private String subject;
	private Integer amount;
	
	public OfferingMatch(String buyCode, String sellCode, String subject, Integer amount) {
		super();
		this.buyCode = buyCode;
		this.sellCode = sellCode;
		this.subject = subject;
		this.amount = amount;
	}

	public String getBuyCode() {
		return buyCode;
	}

	public String getSellCode() {
		return sellCode;
	}

	public String getSubject() {
		return subject;
	}

	public Integer getAmount() {
		return amount;
	}
	
	
}
