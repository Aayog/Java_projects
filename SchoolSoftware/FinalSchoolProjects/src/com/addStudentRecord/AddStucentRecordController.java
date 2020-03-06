package com.addStudentRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import com.alertBox.ShowAlertBox;
import com.jdbc.StudentInfoCrudService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.studentModel.Student_Crud_Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddStucentRecordController implements Initializable {

	@FXML
	private JFXTextField firstName;

	@FXML
	private JFXTextField middleName;

	@FXML
	private JFXTextField lastName;

	@FXML
	private JFXTextField imagePath;

	@FXML
	private JFXButton picBrows;

	@FXML
	private JFXTextField phone;

	@FXML
	private JFXTextField address;

	@FXML
	private JFXTextField email;

	@FXML
	private JFXTextField roll;

	@FXML
	private JFXComboBox<String> clash;

	@FXML
	private JFXDatePicker admitionDate;

	@FXML
	private JFXTextField parents;

	@FXML
	private JFXButton saveAndNextButton;

	@FXML
	private JFXButton clearButton;

	File file = null;

	@FXML
	void onClickClearButton(ActionEvent event) {

	}

	@FXML
	void onClickPicBrows(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Image File");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("GIF", "*.gif"),
				new FileChooser.ExtensionFilter("BMP", "*.bmp"), new FileChooser.ExtensionFilter("PNG", "*.png"));

		file = fileChooser.showOpenDialog(new Stage());
		if (file != null) {
			imagePath.setText(file.toString());
		}

	}

	ShowAlertBox alert = new ShowAlertBox();
	StudentInfoCrudService crud = new StudentInfoCrudService();

	@FXML
	void onClickedSaveAndNextButton(ActionEvent event) {

		File image = new File(file.toString());
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(image);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (firstName.getText().isEmpty())
			alert.showAlert("W", "FIRST NAME CAN NOT BE EMPTY !!!", "EMPTY FIELD !!!");
		else if (lastName.getText().isEmpty())
			alert.showAlert("W", "LAST NAME CAN NOT BE EMPTY !!!", "EMPTY FIELD !!!");
		else if (fis.equals(null))
			alert.showAlert("W", "LAST NAME CAN NOT BE EMPTY !!!", "EMPTY FIELD !!!");
		else if (phone.getText().isEmpty())
			alert.showAlert("W", "PHONE NUMBER CAN NOT BE EMPTY !!!", "EMPTY FIELD !!!");
		else if (address.getText().isEmpty())
			alert.showAlert("W", "ADDRESS CAN NOT BE EMPTY !!!", "EMPTY FIELD !!!");
		else if (clash.getValue().toString().equals("CLASS"))
			alert.showAlert("W", "SELECT ONR OF CLASS !!!", "EMPTY FIELD !!!");
		else if (roll.getText().isEmpty())
			alert.showAlert("W", "ROLL NUMBER CAN NOT BE EMPTY!!!", "EMPTY FIELD !!!");
		else {

			Student_Crud_Model mstudentModel = new Student_Crud_Model(-1, firstName.getText().trim().toString(),
					middleName.getText().trim().toString(), lastName.getText().trim().toString(), fis,
					phone.getText().trim().toString(), address.getText().trim().toString(),
					email.getText().trim().toString(), Integer.valueOf(clash.getValue()),
					Integer.valueOf(roll.getText().trim()), admitionDate.getValue().toString(),
					parents.getText().trim(), "SANLAMA", "", "", "");

			if (crud.insertData(mstudentModel))
				alert.showAlert("I", "SUCCESSFULLY DATA ADDED", "STUDENT DATA ADDED !!!");

			try {
				
				
				
				
				
			}catch(Exception ex) {
				System.out.println(ex.toString()+"1");
			}

		}
	}

	ObservableList<String> options = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imagePath.setEditable(false);
		clash.getItems().addAll(options);
	}

}
