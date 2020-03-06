package com.Add;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

public class AddExamController implements Initializable {
	private AddDatabase addDatabase = new AddDatabase();

	@FXML
	private JFXComboBox<String> examSelect;

	@FXML
	private JFXComboBox<Integer> selectClass;

	@FXML
	private JFXComboBox<String> subjectSelect;

	@FXML
	private JFXTextField practicalFM;

	@FXML
	private JFXTextField theoryFM;

	@FXML
	private JFXTextField practicalPM;

	@FXML
	private JFXTextField theoryPM;

	@FXML
	void onClickClear(ActionEvent event) {
		examSelect.getSelectionModel().clearSelection();
		selectClass.getSelectionModel().clearSelection();
		subjectSelect.getSelectionModel().clearSelection();
		practicalFM.clear();
		theoryFM.clear();
		theoryPM.clear();
		practicalPM.clear();
	}
	
	@FXML
    void onTypeText(KeyEvent event) {
		System.out.println("Text changed");
		if(!theoryFM.getText().isEmpty()) {
			int theory_fm = Integer.parseInt(theoryFM.getText().trim());
			if(theory_fm > 0) {
				theoryPM.setText(String.valueOf((int)(theory_fm*0.4)));
			}
		}
    }
	
	@FXML
	void onTypePractical(KeyEvent event) {
		System.out.println("Practical Text changed");
		if(!practicalFM.getText().isEmpty()) {
			int practical_fm = Integer.parseInt(practicalFM.getText().trim());
			if(practical_fm > 0) {
				practicalPM.setText(String.valueOf((int)(practical_fm*0.4)));
			}
		}
	}

	@FXML
	void onClickDone(ActionEvent event) {
		if (examSelect.getSelectionModel().isEmpty()) {
			// TODO : error EMPTY Selection
			System.out.println("Error : examSelect");
		} else if (selectClass.getSelectionModel().isEmpty()) {
			// TODO : error EMPTY Selection
			System.out.println("Error : selectClass");
		} else if (subjectSelect.getSelectionModel().isEmpty()) {
			// TODO : error EMPTY Selection
			System.out.println("Error : subject");
		} else if (theoryFM.getText().isEmpty()) {
			// TODO : error EMPTY Text field
			System.out.println("Error : theoryFM");
		} else if (practicalFM.getText().isEmpty()) {
			// TODO : error EMPTY Text field
			System.out.println("Error : practicalFM");
		} else if (theoryPM.getText().isEmpty()) {
			// TODO : error EMPTY Text field
			System.out.println("Error : theoryPM");
		} else if (practicalPM.getText().isEmpty()) {
			// TODO : error EMPTY Text field
			System.out.println("Error : practicalPM");
		} else {
			System.out.println("GOOD to go");
			if(addDatabase.insertExamInfo(new AddSubjectModel(examSelect.getValue().trim(), selectClass.getValue(), subjectSelect.getValue().trim(),(int) Integer.parseInt(theoryFM.getText()), (int)Integer.parseInt(theoryPM.getText()),(int) Integer.parseInt(practicalFM.getText()), (int)Integer.parseInt(practicalPM.getText())))) {
				System.out.println("Inserted");
				//TODO : alert inserted data
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> examList = FXCollections.observableArrayList();
		ObservableList<Integer> classList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		selectClass.getItems().clear();
		selectClass.getItems().addAll(classList);
		selectClass.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				if(!selectClass.getSelectionModel().isEmpty()) setSubject(newValue);
			}

			public void setSubject(Integer newVal) {
				ObservableList<String> subDatas = FXCollections.observableArrayList();

				try {
					
					ResultSet result = addDatabase.selectRow("SUBJECT_NAME","subject_record","CLASS",String.valueOf(newVal));
					while (result.next()) {
						subDatas.add(result.getString(1));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				subjectSelect.getItems().clear();
				subjectSelect.getItems().addAll(subDatas);

			}
		});

		try {
			
			ResultSet result = addDatabase.selectRow("EXAM_NAME", "exam_info", "1", "1");
			while (result.next()) {
				examList.add(result.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		examSelect.getItems().clear();
		examSelect.getItems().addAll(examList);

	}

}
