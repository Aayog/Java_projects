package com.test;

import java.io.File;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
	File file = null;
	int count = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
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
						;
					}

				}
			});

			saveAndNext.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// to send data in database

				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
