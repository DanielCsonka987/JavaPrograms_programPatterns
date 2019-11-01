package application;

public class TextMemento {

	private String savedText;

	public TextMemento(String savedText) {
		super();
		this.savedText = savedText;
	}
	
	public String getSavedText(){
		return savedText;
	}
	
}
