package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataBaseLikeClass {

	private static ObservableList<OrderingDatas> list;
	private DataBaseLikeClass() { } 
	
	public static ObservableList<OrderingDatas> getListOfOrderings(){
		if(list == null){
			list = FXCollections.observableArrayList();
			OrderingDatas newOrd = new OrderingDatas(
					0, "Socks", "M", "Grey", 2	);
			list.add(newOrd);
		}
		return list;
	}
	
	public static void saveNewOrdering(OrderingDatas newOrd){
		list.add(newOrd);
	}
}
