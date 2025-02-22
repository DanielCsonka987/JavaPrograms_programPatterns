package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable {
	@FXML
	private TableView<Employee> tableEmployee;

	@FXML
	private TableColumn<Employee, Number> ids;
	@FXML
	private TableColumn<Employee, String> names;
	@FXML
	private TableColumn<Employee, String> genders;
	@FXML
	private TableColumn<Employee, Number> birthYears;
	@FXML
	private TableColumn<Employee, String> positions;
	@FXML
	private TableColumn<Employee, String> areas;

	@FXML
	private TextField txtFieldName1;

	@FXML
	private Button btnAddOne;

	@FXML
	private Button btnAddTwo;

	@FXML
	private ComboBox<String> cmbbxPosit;

	@FXML
	private ComboBox<String> cmbbxArea;

	@FXML
	private TextField txtFieldName2;

	@FXML
	private ComboBox<String> cmbbxGender;

	@FXML
	private TextField txtFieldBirth;

	private ObservableList<Employee> list;
	private Integer counter = 1;
	private Integer birthDate;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		list = FXCollections.observableArrayList();
		
		loadInTestData();
		adjustTableView();
		refreshTableViewContentAndFields();
	}

	private void adjustTableView() {

		ids = new TableColumn<Employee, Number>("ID");
		ids.setCellValueFactory(c -> c.getValue().getIdProp());
		names = new TableColumn<Employee, String>("Name");
		names.setPrefWidth(100);
		names.setCellValueFactory(c -> c.getValue().getNameProp());
		genders = new TableColumn<Employee, String>("Gender");
		genders.setCellValueFactory(c -> c.getValue().getGenderProp());
		birthYears = new TableColumn<Employee, Number>("Birth");
		birthYears.setCellValueFactory(c -> c.getValue().getBirthYearProp());
		positions = new TableColumn<Employee, String>("Position");
		positions.setPrefWidth(120);
		positions.setCellValueFactory(c -> c.getValue().getPositionProp());
		areas = new TableColumn<Employee, String>("Area");
		areas.setPrefWidth(90);
		areas.setCellValueFactory(c -> c.getValue().getAreaProp());

		tableEmployee.getColumns().addAll(ids, names, genders, birthYears, positions, areas);

	}

	private void loadInTestData() {
		list.add(new Employee(counter, "James Bond", "male", 1932, "Director", "London"));
		counter++;
	}


	private void refreshTableViewContentAndFields() {
		tableEmployee.setItems(list);
		
		txtFieldName1.setText("");
		cmbbxPosit.getSelectionModel().clearSelection();
		cmbbxArea.getSelectionModel().clearSelection();
		
		txtFieldName2.setText("");
		cmbbxGender.getSelectionModel().clearSelection();
		txtFieldBirth.setText("");
	}

	
	@FXML
	void saveFirstFormContent(ActionEvent event) {
		if(reviseFormOneFilled()){
			Employee emp = new EmployeeBuilder(counter, txtFieldName1.getText())
					.setArea(cmbbxArea.getSelectionModel().getSelectedItem())
					.setPosition(cmbbxPosit.getSelectionModel().getSelectedItem())
					.finishBuild();
			list.add(emp);
			counter++;
			refreshTableViewContentAndFields();
		}
	}

	private boolean reviseFormOneFilled() {
		if(txtFieldName1.getText().isEmpty())
			return false;
		if(cmbbxPosit.getSelectionModel().isEmpty())
			return false;
		if(cmbbxArea.getSelectionModel().isEmpty())
			return false;
		return true;
	}

	@FXML
	void saveSecondFromContent(ActionEvent event) {
		if(reviseFormTwoFilled()){
			Employee emp = new EmployeeBuilder(counter, txtFieldName2.getText())
					.setGender(cmbbxGender.getSelectionModel().getSelectedItem())
					.setBirthYear(birthDate)
					.finishBuild();
			list.add(emp);
			counter++;
			refreshTableViewContentAndFields();
		}
		
	}

	private boolean reviseFormTwoFilled() {
		if(txtFieldName2.getText().isEmpty())
			return false;
		if(cmbbxGender.getSelectionModel().isEmpty())
			return false;
		if(txtFieldBirth.getText().isEmpty())
			return false;
		try{
			birthDate = Integer.parseInt(txtFieldBirth.getText());
		}catch(Exception e)
		{
			e.getStackTrace();
			return false;
		}
		return true;
	}

}
