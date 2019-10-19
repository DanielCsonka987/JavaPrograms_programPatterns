package application;

import applicationExtension.SingleAdaptorOutput;

public class AdaptorInputLongText implements IMessaging{

	@Override
	public void sendTheMessage(String message) {
		SingleAdaptorOutput out = new SingleAdaptorOutput();
		out.sendTheMessageToAddresse("Long-text: "+message);
		
	}

}
