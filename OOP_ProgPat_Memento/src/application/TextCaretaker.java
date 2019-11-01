package application;

import java.util.ArrayList;
import java.util.List;

public class TextCaretaker {

	List<TextMemento> listOfSavings = new ArrayList<TextMemento>();
	
	public void addNewMemento(TextMemento act){
		
		listOfSavings.add(act);
	}
	
	public TextMemento getMemento(Integer index){
		
		return listOfSavings.get(index);
	}

	public Boolean remveMementi(Integer index){
		if(index >= listOfSavings.size())
			return false;
		int keyLocation = index;
		Boolean res = (listOfSavings.remove(keyLocation) != null)? true: false ;
		return res;
	}
}
