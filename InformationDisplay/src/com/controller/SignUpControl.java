package com.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.Model.SignUpModel;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUpControl {

    @FXML
    private JFXTextField userText;

    @FXML
    private JFXTextField passText;

    @FXML
    void onClickLogin(ActionEvent event) {
    		SignUpModel model = new SignUpModel();
    		if(userText.getText().isEmpty()) {
    			System.out.println("Username empty");
    		}else if(passText.getText().isEmpty()) {
    			System.out.println("Password empty");
    		}else {
    			try {
    				Class.forName("com.mysql.jdbc.Driver");
    				Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nepdroid_class","root","");
    				String sql = "SELECT * FROM StudentRecord WHERE UserName = ?";
    				PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
    				pstm.setString(1, userText.getText().trim().toUpperCase());
    				System.out.println(pstm.toString());
    				ResultSet result = pstm.executeQuery();
    				while(result.next()) {
    					model.setFname(result.getString(2));
    					model.setLname(result.getString(3));
    					model.setEmail(result.getString(4));
    					model.setPhone(result.getString(5));
    					model.setAddress(result.getString(6));
    					model.setShift(result.getString(7));
    					model.setImageStream(result.getBinaryStream(8));
    					model.setPassword(result.getString(9));
    					model.setUserName(result.getString(10));
    				}
    				try {
    					FXMLLoader loader= new FXMLLoader();
    					Stage stage = new Stage();
    					Parent root = loader.load(getClass().getResource("/com/fxml/InformationDisplay.fxml").openStream());
    					InformationDisplay controller = loader.getController();
    					controller.setValue(model);
    					Scene scene = new Scene(root);
    					stage.setScene(scene);
    					stage.show();
    					
    				}catch (Exception e) {
    					System.out.println(e.toString());	
    					e.printStackTrace();

    				}
    			}catch (Exception e) {
    				System.out.println(e.toString());
			}
    		}
    }

}
