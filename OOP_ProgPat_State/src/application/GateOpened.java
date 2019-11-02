package application;

public class GateOpened implements IGateState {

	private BehaveOfGate actGateBehave;
	private String paymentText;
	private String entrenceText;
	
	public GateOpened(BehaveOfGate actGateLogic) {
		super();
		this.actGateBehave = actGateLogic;
		entrenceText = "You may enter";
		paymentText = "You paid enough\nto enter!";
	}

	@Override
	public Boolean payFee(Integer amount) {
		
		if(amount >= 100){
			paymentText = "You already paid\nfor the enterce!";
			return false;
		}else{
			return false;
		}
		
	}

	@Override
	public Boolean enterTheGate() {
		
		actGateBehave.changeStateOfBehave(new GateClosed(actGateBehave));
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
