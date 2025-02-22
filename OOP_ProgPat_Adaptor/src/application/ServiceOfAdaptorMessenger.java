package application;

import applicationExtension.SingleAdaptorOutput;
import javafx.collections.ObservableList;

public class ServiceOfAdaptorMessenger {
	private IMessaging sending;
	
	public void sendLongText(String longMessage){
		sending = new AdaptorInputLongText();
		sending.sendTheMessage(doTheBreaking(longMessage));
	}
	
	private String doTheBreaking(String longMessage){
		if(longMessage.length() > 25){
			Integer counterEnd = 0;
			String finalMessage = "";
			while (counterEnd <= longMessage.length()){
				if(counterEnd + 25 > longMessage.length())
					finalMessage += longMessage.substring(counterEnd, longMessage.length());
				else{
					finalMessage += longMessage.substring(counterEnd, counterEnd + 25);
					finalMessage += "\n";
				}
				counterEnd = counterEnd + 25;
			}
			return finalMessage;
		} else {
			return longMessage;
		}
	}
	
	public void sendShortText(String shortMessage){
		sending = new AdaptorInputShortText();
		sending.sendTheMessage(shortMessage);
	}
	
	public void sendCalculateableText(Integer num1, Integer num2, Operation op){
		Integer result = 0;
		try{
			if(op == Operation.ADDING)
				result = num1 + num2;
			else if(op == Operation.SUBTARCTING)
				result = num1 - num2;
			else if(op == Operation.MULTIPLYING)
				result = (Integer) (num1 * num2);
			else {
				if(num2 == 0)
					result = 0;
				result = (Integer)(num1 / num2);
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
		String finalMessage = result.toString();
		sending = new AdaptorInputCalculateingText();
		sending.sendTheMessage(finalMessage);
	}
	
	public enum Operation {
		ADDING, SUBTARCTING, MULTIPLYING, DIVIDING
	}
	
	
	public ObservableList<String> getBackTheMessageResult(){
		return SingleAdaptorOutput.getTheMessages();
	}
}
