package com.school.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainAppDashboardLoader extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root=FXMLLoader.load(getClass().getResource("MainDashboard.fxml"));
			Scene scene=new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			//primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
		}catch(Exception ex) {
			ex.printStackTrace();

			System.out.println(ex.toString());
		}
		
	}

}
