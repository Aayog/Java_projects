package com.addStudentRecord;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.alertBox.ShowAlertBox;
import com.jdbc.StudentInfoCrudService;
import com.jdbc.StudentInfoViewService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.studentModel.Student_Crud_Model;
import com.studentModel.Student_model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StudentViewController implements Initializable {
	File file;

	private ObservableList<Student_model> studentData = FXCollections.observableArrayList();
	int count = 0;

	@FXML
	private TableView<Student_model> studentViewTable;

	@FXML
	private TableColumn<Student_model, String> firstName;

	@FXML
	private TableColumn<Student_model, String> middleName;

	@FXML
	private TableColumn<Student_model, String> lastName;

	@FXML
	private TableColumn<Student_model, String> clash;

	@FXML
	private TableColumn<Student_model, String> roll;

	@FXML
	private TableColumn<Student_model, String> parent;

	@FXML
	private TableColumn<Student_model, String> phone;

	@FXML
	private TableColumn<Student_model, String> admitDate;

	@FXML
	private ImageView studentImage;

	@FXML
	private Label fullNameLabel;

	@FXML
	private JFXButton updateButton;

	@FXML
	private JFXButton addStudentInfoButton;

	@FXML
	private JFXButton searchButton;

	@FXML
	private JFXComboBox<String> columnSelection;

	@FXML
	void onClickSearchButton(ActionEvent event) {

		System.out.println("ok");

	}

	ObservableList<String> options = FXCollections.observableArrayList("STUDENT-ID", "STUDENT-NAME", "PHONE");

	@FXML
	void onClickUpdateButton(ActionEvent event) {

	}

	@FXML
	void onClickedAddStudentInfoButton(ActionEvent event) {

		try {

			Stage primaryStage = new Stage();
			Text text = new Text("PROVIDE THE INFORMATION BELOW !!!");
			text.setFill(Paint.valueOf("#f44242"));

			Separator sep = new Separator();

			JFXTextField firstName = new JFXTextField();
			firstName.setMaxWidth(300);
			firstName.setPromptText("FIRST NAME");
			firstName.setLabelFloat(true);
			JFXTextField middleName = new JFXTextField();
			middleName.setPromptText("MIDDLE NAME");
			middleName.setLabelFloat(true);
			middleName.setMaxWidth(300);
			JFXTextField lastName = new JFXTextField();
			lastName.setPromptText("LAST NAME");
			lastName.setLabelFloat(true);
			lastName.setMaxWidth(300);
			JFXTextField image = new JFXTextField();
			image.setEditable(false);
			image.setPromptText("IMAGE PATH");
			image.setLabelFloat(true);
			image.setMaxWidth(300);
			JFXTextField phone = new JFXTextField();
			phone.setPromptText("PHONE NUMBER");
			phone.setLabelFloat(true);
			phone.setMaxWidth(300);
			JFXTextField address = new JFXTextField();
			address.setPromptText("ADDRESS");
			address.setLabelFloat(true);
			address.setMaxWidth(300);
			JFXTextField email = new JFXTextField();
			email.setPromptText("E-MAIL");
			email.setLabelFloat(true);
			email.setMaxWidth(300);
			JFXTextField roll = new JFXTextField();
			roll.setPromptText("ROLL");
			roll.setLabelFloat(true);
			roll.setMaxWidth(300);
			JFXTextField parent = new JFXTextField();
			parent.setPromptText("PARENT");
			parent.setLabelFloat(true);
			parent.setMaxWidth(300);

			ObservableList<String> options = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8",
					"9", "10");
			JFXComboBox<String> clash = new JFXComboBox<>(options);
			clash.setPrefWidth(300);

			JFXDatePicker date = new JFXDatePicker();
			date.setPrefWidth(335);
			JFXButton browseImage = new JFXButton("BROWS PICTURE");
			JFXButton saveAndNext = new JFXButton("SAVE AND NEXT");
			saveAndNext.setPrefHeight(40);
			JFXButton clear = new JFXButton("CLEAR");
			clear.setPrefHeight(40);
			clear.setPrefWidth(100);

			VBox vb = new VBox();
			HBox buttonVb = new HBox();
			buttonVb.setAlignment(Pos.CENTER);
			buttonVb.setPadding(new Insets(0, 0, 20, 0));
			vb.setAlignment(Pos.CENTER);
			vb.getChildren().add(text);

			buttonVb.getChildren().addAll(saveAndNext, clear);
			buttonVb.setSpacing(20);

			BorderPane border = new BorderPane();
			border.setTop(vb);
			border.setBottom(buttonVb);

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setVgap(20);

			grid.add(firstName, 0, 0);
			grid.add(middleName, 0, 1);
			grid.add(lastName, 0, 2);
			grid.add(image, 0, 3);
			grid.add(browseImage, 1, 3);
			grid.add(phone, 0, 4);
			grid.add(address, 0, 5);
			grid.add(email, 0, 6);
			grid.add(clash, 0, 7);
			grid.add(date, 0, 8);
			grid.add(roll, 0, 9);
			grid.add(parent, 0, 10);

			border.setCenter(grid);

			Scene scene = new Scene(border, 500, 600);
			primaryStage.setScene(scene);
			primaryStage.show();

			ShowAlertBox alert = new ShowAlertBox();
			StudentInfoCrudService crud = new StudentInfoCrudService();

			browseImage.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {

					FileChooser fileChooser = new FileChooser();
					fileChooser.setTitle("Open Image File");
					fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

					fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
							new FileChooser.ExtensionFilter("JPG ", "*.jpg"),
							new FileChooser.ExtensionFilter("GIF", "*.gif"),
							new FileChooser.ExtensionFilter("BMP", "*.bmp"),
							new FileChooser.ExtensionFilter("PNG", "*.png"));

					if (count == 0) {
						count = 8;
						file = fileChooser.showOpenDialog(new Stage());
						if (file != null) {
							image.setText(file.toString());
							count = 0;

						} else {
							count = 0;
						}
					}

				}
			});

			saveAndNext.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					File image = new File(file.toString());
					FileInputStream fis = null;
					try {
						fis = new FileInputStream(image);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Student_Crud_Model mstudentModel = new Student_Crud_Model(-1, firstName.getText().trim().toString(),
							middleName.getText().trim().toString(), lastName.getText().trim().toString(), fis,
							phone.getText().trim().toString(), address.getText().trim().toString(),
							email.getText().trim().toString(), Integer.valueOf(clash.getValue()),
							Integer.valueOf(roll.getText().trim()), date.getValue().toString(), parent.getText().trim(),
							"SANLAMA", "", "", "");

					if (crud.insertData(mstudentModel))
						refreshTable();
					alert.showAlert("I", "SUCCESSFULLY DATA ADDED", "STUDENT DATA ADDED !!!");
				}

				private void refreshTable() {
					try {
						ResultSet result = new StudentInfoViewService().getStudentRecord();
						studentData.clear();

						while (result.next()) {
							studentData.add(new Student_model(result.getInt(1), result.getString(2),
									result.getString(3), result.getString(4), new Image(result.getBinaryStream(5)),
									result.getString(6), result.getString(7), result.getString(8), result.getInt(9),
									result.getInt(10), result.getString(12), result.getString(11), result.getString(14),
									result.getString(15), result.getString(13), result.getString(16)));
						}
						studentViewTable.setItems(studentData);
						studentViewTable.refresh();

					} catch (Exception ex) {
						System.out.println(ex.toString());
					}

				}

			});

		} catch (Exception ex) {
			System.out.println(ex.toString() + "on click addStudentButton");
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		columnSelection.getItems().addAll(options);

		firstName.setCellValueFactory(new PropertyValueFactory<Student_model, String>("firstName"));
		middleName.setCellValueFactory(new PropertyValueFactory<Student_model, String>("middleName"));
		lastName.setCellValueFactory(new PropertyValueFactory<Student_model, String>("lastName"));
		clash.setCellValueFactory(new PropertyValueFactory<Student_model, String>("clash"));
		roll.setCellValueFactory(new PropertyValueFactory<Student_model, String>("roll"));
		parent.setCellValueFactory(new PropertyValueFactory<Student_model, String>("parent"));
		phone.setCellValueFactory(new PropertyValueFactory<Student_model, String>("phone"));
		admitDate.setCellValueFactory(new PropertyValueFactory<Student_model, String>("admitionDate"));

		ResultSet result = new StudentInfoViewService().getStudentRecord();

		try {
			while (result.next()) {
				studentData.add(new Student_model(result.getInt(1), result.getString(2), result.getString(3),
						result.getString(4), new Image(result.getBinaryStream(5)), result.getString(6),
						result.getString(7), result.getString(8), result.getInt(9), result.getInt(10),
						result.getString(12), result.getString(11), result.getString(14), result.getString(15),
						result.getString(13), result.getString(16)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("from student data add list" + e.toString());
		}

		studentViewTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		studentViewTable.setItems(studentData);

		studentViewTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student_model>() {

			@Override
			public void changed(ObservableValue<? extends Student_model> observable, Student_model oldValue,
					Student_model newValue) {
				studentImage.setImage(newValue.getImage());
				fullNameLabel.setText(
						(newValue.getFirstName() + " " + newValue.getMiddleName() + " " + newValue.getLastName())
								.toUpperCase());
			}

		});

	}

}
