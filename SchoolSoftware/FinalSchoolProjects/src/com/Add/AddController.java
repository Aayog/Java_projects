package com.Add;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AddController implements Initializable{
	
	private AnchorPane examAnchor;
	private AnchorPane resultAnchor;
    
	@FXML
    private AnchorPane mainAddAnchor;
    
    
	@FXML
	private JFXButton addExamButton;

	@FXML
	private JFXButton addStudentResultButton;

	@FXML
	void onClickAddExamButton(ActionEvent event) {
		mainAddAnchor.getChildren().clear();
		mainAddAnchor.getChildren().add(examAnchor);
	}

	@FXML
	void onClickAddStudentResultButton(ActionEvent event) {
		mainAddAnchor.getChildren().clear();
		mainAddAnchor.getChildren().add(resultAnchor);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			examAnchor = FXMLLoader.load(getClass().getClassLoader().getResource("com/Add/AddExam.fxml"));
			resultAnchor = FXMLLoader.load(getClass().getClassLoader().getResource("com/Add/AddResult.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
