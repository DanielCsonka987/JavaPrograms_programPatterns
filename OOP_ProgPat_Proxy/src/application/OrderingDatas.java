package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class OrderingDatas {
	
	private SimpleIntegerProperty orderId;
	private SimpleStringProperty clothesName;
	private SimpleStringProperty clothesSize;
	private SimpleStringProperty clothesColor;
	private SimpleIntegerProperty clothesAmount;
	
	
	
	public OrderingDatas(Integer orderId, String clothesName, String clothesSize,
			String clothesColor, Integer clothesAmount) {
		super();
		this.orderId = new SimpleIntegerProperty();
		this.orderId.set(orderId);
		this.clothesName = new SimpleStringProperty();
		this.clothesName.set(clothesName);
		this.clothesSize = new SimpleStringProperty();
		this.clothesSize.set(clothesSize);
		this.clothesColor = new SimpleStringProperty();
		this.clothesColor.set(clothesColor);
		this.clothesAmount = new SimpleIntegerProperty();
		this.clothesAmount.set(clothesAmount);
	}
	
	public SimpleIntegerProperty getOrderId() {
		return orderId;
	}

	public SimpleStringProperty getClothesName() {
		return clothesName;
	}
	public SimpleStringProperty getClothesSize() {
		return clothesSize;
	}
	public SimpleStringProperty getClothesColor() {
		return clothesColor;
	}
	public SimpleIntegerProperty getClothesAmount() {
		return clothesAmount;
	}

	
	
}
