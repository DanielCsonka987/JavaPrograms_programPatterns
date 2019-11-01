package application;

public class TextOriginator {

	private String managedText;

	public void setSavedText(String text){
		managedText = text;
	}
	
	public TextMemento storeNewTextMemento(){
		
		return new TextMemento(managedText);
	}

	public String restoreTextMemento(TextMemento prev ){
		
		return prev.getSavedText();
	}
	
	public Integer removeTextMementi(Integer index){
		return index;
	}
}
