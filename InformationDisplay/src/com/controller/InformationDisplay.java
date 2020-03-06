package com.controller;

import java.io.InputStream;

import com.Model.SignUpModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class InformationDisplay{
	String welcome, fname,lname,shift,phone,address;
	InputStream imageStream;
	Image image;
    @FXML
    private Label welcomeText;

    @FXML
    private Text fnameText;

    @FXML
    private Text lnameText;

    @FXML
    private Text shiftText;

    @FXML
    private Text phoneText;

    @FXML
    private Text addressText;
    
    @FXML
    private Circle circle;
    
    public void setValue(SignUpModel model) {
    		welcomeText.setText("Welcome "+model.getFname()+" "+model.getLname());
    		fnameText.setText((model.getFname()));
    		lnameText.setText((model.getLname()));
    		shiftText.setText((model.getShift()));
    		phoneText.setText((model.getPhone()));
    		addressText.setText((model.getAddress()));    		
    		image = new Image(model.getImageStream());
		circle.setFill(new ImagePattern(image));
    }


}
