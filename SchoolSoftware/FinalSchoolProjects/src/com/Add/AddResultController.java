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
import javafx.scene.control.Label;

public class AddResultController implements Initializable{
	
	private AddDatabase addDatabase = new AddDatabase();
    @FXML
    private JFXComboBox<String> examSelect;

    @FXML
    private JFXComboBox<Integer> selectClass;

    @FXML
    private JFXComboBox<String> selectSubject;

    @FXML
    private JFXComboBox<Integer> selectRollNumber;

    @FXML
    private JFXTextField obtainedPracticalMarks;

    @FXML
    private JFXTextField obtainedTheoryMarks;

    @FXML
    private Label theoryFM;

    @FXML
    private Label practicalFM;

    @FXML
    void onClickClear(ActionEvent event) {
    		examSelect.getSelectionModel().clearSelection();
    		selectClass.getSelectionModel().clearSelection();
    		selectSubject.getSelectionModel().clearSelection();
    		selectRollNumber.getSelectionModel().clearSelection();
    		obtainedPracticalMarks.clear();
    		obtainedTheoryMarks.clear();
    		theoryFM.setText("");
    		practicalFM.setText("");
    }

    @FXML
    void onClickNext(ActionEvent event) {
    		if(examSelect.getSelectionModel().isEmpty()) {
    			//TODO :error
    			System.out.println("Empty exam selection");
    		}else if(selectClass.getSelectionModel().isEmpty()) {
    			//TODO :error
    			System.out.println("Empty class selection");
    		}else if(selectSubject.getSelectionModel().isEmpty()) {
    			//TODO :error
    			System.out.println("Empty subject selection");
    		}else if(selectRollNumber.getSelectionModel().isEmpty()) {
    			//TODO :error
    			System.out.println("Empty roll selection");
    		}else if(obtainedTheoryMarks.getText().isEmpty()) {
    			//TODO :error
    			System.out.println("Empty theory marks field");
    		}else if(obtainedPracticalMarks.getText().isEmpty()) {
    			//TODO :error
    			System.out.println("Empty theory marks field");
    		}else {
    			int theoryOM, practicalOM;
    			theoryOM = Integer.parseInt(obtainedTheoryMarks.getText());
    			practicalOM = Integer.parseInt(obtainedPracticalMarks.getText());

    			if(theoryOM <= Integer.parseInt(theoryFM.getText()) && practicalOM <= Integer.parseInt(practicalFM.getText())) {
    				setRollNumber(selectClass.getValue());
    			}
    		}
    }

    @FXML
    void onClickViewInfo(ActionEvent event) {

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		ObservableList<Integer> classList = FXCollections.observableArrayList();
		try {
			ResultSet result = addDatabase.selectRow("DISTINCT CLASS", "fm_pm_table", "1", "1 ORDER BY CLASS");
			while (result.next()) {
				classList.add(result.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			classList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
		}

		selectClass.getItems().clear();
		selectClass.getItems().addAll(classList);
		selectClass.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
				setSubject(newValue);
			}
			public void setSubject(Integer newVal) {
				ObservableList<String> subDatas = FXCollections.observableArrayList();
				
				try {
					ResultSet result = addDatabase.selectRow("SUBJECT_NAME", "fm_pm_table", "CLASS", String.valueOf(newVal));
					while(result.next()) {
						subDatas.add(result.getString(1));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				selectSubject.getItems().clear();
				selectSubject.getItems().addAll(subDatas);
				
			}
		});
		//TODO Exam list from Database after new exam created..
		ObservableList<String> examList = FXCollections.observableArrayList();
		try {
			ResultSet result = addDatabase.selectRow("EXAM_NAME", "exam_info", "1", "1");
			while(result.next()) {
				examList.add(result.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		examSelect.getItems().clear();
		examSelect.getItems().addAll(examList);	
		selectSubject.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					setRollNumber(selectClass.getValue());				

					ResultSet result = addDatabase.selectRowWithTwoColumn("THEORY_FM","PRACTICAL_FM","fm_pm_table","class",selectClass.getValue().toString(),"SUBJECT_NAME",newValue);
					while(result.next()) {
						theoryFM.setText(result.getString(1));
						practicalFM.setText(result.getString(2));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (Integer.parseInt(practicalFM.getText())<=0) {
					obtainedPracticalMarks.setText("0");
				}
			}
			
		});
		
	}
	private void setRollNumber(int newValue) {
		ObservableList<Integer> rollList = FXCollections.observableArrayList();
		int _class = newValue;
		String subject = selectSubject.getValue().trim().toString();
		try {
				ResultSet result = addDatabase.getRollNumber(_class,subject );
				while(result.next()) {
					rollList.add(result.getInt(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		selectRollNumber.getItems().clear();
		selectRollNumber.getItems().addAll(rollList);
		selectRollNumber.getSelectionModel().select(0);
		}

}
