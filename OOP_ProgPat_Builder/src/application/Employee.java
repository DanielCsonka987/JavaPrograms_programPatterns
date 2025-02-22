package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class Employee {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty gender;
	private SimpleIntegerProperty birthYear;
	private SimpleStringProperty position;
	private SimpleStringProperty area;
	public Employee(Integer id, String name, String gender, Integer birthYear, String position, String area) {
		super();
		this.id = new SimpleIntegerProperty();
		this.id.setValue(id);
		this.name = new SimpleStringProperty();
		this.name.set(name);
		this.gender = new SimpleStringProperty();
		this.gender.set(gender);
		this.birthYear = new SimpleIntegerProperty();
		this.birthYear.set(birthYear);
		this.position = new SimpleStringProperty();
		this.position.set(position);
		this.area = new SimpleStringProperty();
		this.area.set(area);
	}
	public SimpleIntegerProperty getIdProp() {
		return id;
	}
	public SimpleStringProperty getNameProp() {
		return name;
	}
	public SimpleStringProperty getGenderProp() {
		return gender;
	}
	public SimpleIntegerProperty getBirthYearProp() {
		return birthYear;
	}
	public SimpleStringProperty getPositionProp() {
		return position;
	}
	public SimpleStringProperty getAreaProp() {
		return area;
	}
	
	
}
