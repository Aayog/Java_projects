package com.book;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class UpdateBookController{
	public SubjectModel subModel;
	
    @FXML
    private JFXTextField subjectName;

    @FXML
    private JFXButton addButton;

    @FXML
    private ComboBox<Integer> _classSelect;
    
    public void setModel(SubjectModel model) {
    		subModel = model;
    		ObservableList<Integer> classList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
    		
    		_classSelect.getItems().clear();
    		_classSelect.getItems().addAll(classList);
    		
    		subjectName.setText(subModel.getSubject_Name());
    		_classSelect.getSelectionModel().select(subModel.get_class()-1);
    }

    @FXML
    void onClickAdd(ActionEvent event) {
	    	if(subjectName.getText().isEmpty()) {
	    		//Error : cant be empty
	    	}else if(_classSelect.getValue().toString().isEmpty()) {
	    		//Error : can't be empty
	    	}else {
	    		BookService serv = new BookService();
	    		if(serv.jdbcHandle(new SubjectModel(subModel.getSubject_ID(),subjectName.getText().trim().toString(),_classSelect.getValue().intValue()), "U")) {
	    			System.out.println("Book updated");
	    		}else {
	    			System.out.println("Error");
	    		}
	    	}
		
    }

    @FXML
    void onClickCancel(ActionEvent event) {
    		try {
	    			Stage stage = (Stage) addButton.getParent().getScene().getWindow();
	        		stage.close();
			} catch (Exception e) {
				System.out.println("Error cancel");
			}
    }

}
