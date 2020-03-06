package com.book;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class AddBookController implements Initializable{

    @FXML
    private JFXTextField subjectName;

    @FXML
    private JFXButton addButton;

    @FXML
    private ComboBox<Integer> _classSelect;

    @FXML
    void onClickAdd(ActionEvent event) {
    		if (addButton.getText().equals("Add")) {
    			if(subjectName.getText().isEmpty()) {
        			//Error : cant be empty
        		}else if(_classSelect.getValue().toString().isEmpty()) {
        			//Error : can't be empty
        		}else {
        			BookService serv = new BookService();
        			if(serv.jdbcHandle(new SubjectModel(subjectName.getText().trim().toString(), _classSelect.getValue().intValue()), "I")) {
        				System.out.println("Book added");
        				addButton.setText("Next");
        			}else {
        				System.out.println("Error");
        			}
        		}
    		}else {
    			subjectName.clear();
    			_classSelect.getSelectionModel().clearSelection();
    			addButton.setText("Add");
    		}
    		
    }

    @FXML
    void onClickCancel(ActionEvent event) {
    		try {
	    			Stage stage = (Stage) addButton.getParent().getScene().getWindow();
	        		stage.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Cancel Error");
			}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> classList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
		_classSelect.getItems().clear();
		_classSelect.getItems().addAll(classList);
	}

}
