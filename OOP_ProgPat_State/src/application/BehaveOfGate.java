package application;

public class BehaveOfGate {

	private IGateState state;
	
	public BehaveOfGate(){
		state = new GateClosed(this);
	}
	
	public String getThePaymentLabel(){
		
		return state.getPaymentLabel();
	}
	
	public String getTheGateStateLabel(){
		
		return state.getGateStateLabel();
	}
	
	public Boolean payThePrice(Integer payment){
		
		return state.payFee(payment);
	}
	
	public Boolean entrTheGate(){
		
		return state.enterTheGate();
	}
	
	/*
	 * ONLY FOR GATE STATES 
	 */
	public void changeStateOfBehave(IGateState newState){
		this.state = newState;
	}
}
