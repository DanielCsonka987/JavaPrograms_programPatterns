package application;

import applicationExtension.SingleAdaptorOutput;

public class AdaptorInputShortText implements IMessaging {

	@Override
	public void sendTheMessage(String message) {
		SingleAdaptorOutput out = new SingleAdaptorOutput();
		out.sendTheMessageToAddresse("Text: "+message);
	}

}
