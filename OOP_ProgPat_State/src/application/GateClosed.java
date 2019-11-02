package application;

public class GateClosed implements IGateState {

	private BehaveOfGate actGateBehave;
	private String paymentText;
	private String entrenceText;
	
	
	public GateClosed(BehaveOfGate actGateBehave) {
		super();
		this.actGateBehave = actGateBehave;
		entrenceText = "You can not enter";
		paymentText = "You did not paid\nfor the entrence!";
	}

	@Override
	public Boolean payFee(Integer amount) {
		
		if(amount >= 100){
			actGateBehave.changeStateOfBehave(new GateOpened(actGateBehave));
			return true;
		}else{
			paymentText = "It is not enough\nmoney to enter!";
			return false;
		}
	}

	@Override
	public Boolean enterTheGate() {
		
		entrenceText = "Refused to enter!";
		return true;
	}

	@Override
	public String getPaymentLabel() {

		return paymentText;
	}

	@Override
	public String getGateStateLabel() {

		return entrenceText;
	}

}
