package application;

public interface IGateState {

	Boolean payFee(Integer amount);
	Boolean enterTheGate();
	
	String getPaymentLabel();
	String getGateStateLabel();
}
