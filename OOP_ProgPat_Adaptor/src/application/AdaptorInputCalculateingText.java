package application;

import applicationExtension.SingleAdaptorOutput;

public class AdaptorInputCalculateingText implements IMessaging {

	@Override
	public void sendTheMessage(String message) {
		SingleAdaptorOutput out = new SingleAdaptorOutput();
		out.sendTheMessageToAddresse("Result: " + message);
		
	}

}
