package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
//import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ObservableList<PieChart.Data> pieDatas = FXCollections.observableArrayList();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nepdroid_class","root","");
			String sql = "SELECT * FROM Year_Data";
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			while(result.next()) {
				pieDatas.add(new PieChart.Data(Integer.toString(result.getInt(1)), result.getInt(2)));
			}
			
			Label titleLabel = new Label("PieChart for Year - Population Data");
			titleLabel.setAlignment(Pos.TOP_LEFT);
			Label currentSlice = new Label();
			
			PieChart chart = new PieChart(pieDatas);
			VBox vbox = new VBox(10);
			vbox.setAlignment(Pos.CENTER);
			vbox.getChildren().addAll(titleLabel,currentSlice,chart);
			
			for(final Data data : pieDatas) {
				data.getNode().setOnMouseEntered(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent event) {
						currentSlice.setText("Year : " + data.getName() + ", Population "+data.getPieValue());
					}
					
				});
				data.getNode().setOnMouseExited(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						currentSlice.setText(null);
					}
				});
			}
			
			
			
			Scene scene = new Scene(vbox);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
