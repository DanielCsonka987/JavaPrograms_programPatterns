package application;

public class EmployeeBuilder {
	private Integer id;
	private String name;
	private String gender;
	private Integer birthYear;
	private String position;
	private String area;

	public EmployeeBuilder (Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public EmployeeBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public EmployeeBuilder setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
		return this;
	}
	public EmployeeBuilder setPosition(String position) {
		this.position = position;
		return this;
	}
	public EmployeeBuilder setArea(String area) {
		this.area = area;
		return this;
	}
	
	public Employee finishBuild(){
		if(birthYear == null)
			birthYear = 0;
		return new Employee(id, name, gender, birthYear, position, area);
	}
}
