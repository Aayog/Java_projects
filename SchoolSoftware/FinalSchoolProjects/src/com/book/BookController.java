package com.book;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.mysql.jdbc.Connection;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BookController implements Initializable{
	private ObservableList<SubjectModel> bookRecord = FXCollections.observableArrayList();
	public SubjectModel currentModel;
	
    @FXML
    private JFXButton addBook;

    @FXML
    private TableView<SubjectModel> bookViewTable;

    @FXML
    private TableColumn<SubjectModel, Integer> subjectID;

    @FXML
    private TableColumn<SubjectModel, Integer> subjectName;
    
    @FXML
    private TableColumn<SubjectModel, Integer> _class;

    @FXML
    private JFXButton updateButton;

    @FXML
    private Label labelName;

    @FXML
    private Label labelClass;

    @FXML
    void onClickAddBook(ActionEvent event) {
    		try {
    			Stage stage = new Stage();
    			Parent root = FXMLLoader.load(getClass().getResource("/com/book/AddBook.fxml"));
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.showAndWait();
    			showTable();
    		} catch (Exception e) {
    			System.out.println("Failed to load AddBook/fxml");
    		}
    }

    @FXML
    void onClickUpdateButton(ActionEvent event) {
    		if(currentModel != null) {
    			FXMLLoader loader = new FXMLLoader();
        		try {
    			Stage stage = new Stage();
    			Parent root = loader.load(getClass().getResource("/com/book/UpdateBook.fxml").openStream());
    			UpdateBookController controller = loader.getController();
    			controller.setModel(currentModel);
    			Scene scene = new Scene(root);
    			stage.setScene(scene);
    			stage.showAndWait();
    			showTable();
    		}catch (Exception e) {
    			System.out.println("Failed to load UpdateBook/fxml");
    			e.printStackTrace();
    		}
    		}else {
    			//TODO : error --> NOT SELCTED
    			System.out.println("NOT SEELCTED");
    		}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showTable();
	}
	
	
	
	
	public void showTable() {
		if (bookRecord != null) bookRecord.clear();
		subjectID.setCellValueFactory(new PropertyValueFactory<SubjectModel, Integer>("subject_ID"));
		subjectName.setCellValueFactory(new PropertyValueFactory<SubjectModel, Integer>("subject_Name"));
		_class.setCellValueFactory(new PropertyValueFactory<SubjectModel, Integer>("_class"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolfinal","root","431501ak");
			String sql = "SELECT * FROM subject_record";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			while(result.next()) {
				bookRecord.add(new SubjectModel(result.getInt(1), result.getString(2), result.getInt(3)));
			}
			bookViewTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SubjectModel>() {

				@Override
				public void changed(ObservableValue<? extends SubjectModel> observable, SubjectModel oldValue,
						SubjectModel newValue) {
					currentModel = newValue;	
					labelClass.setText("Class : " + Integer.toString(newValue.get_class()));
					labelName.setText(newValue.getSubject_Name());

				}
			
			});
			
		}catch (Exception e) {
			System.out.println("Database : "+e.toString());
		}
		bookViewTable.setItems(bookRecord);
		bookViewTable.refresh();
	}

}
