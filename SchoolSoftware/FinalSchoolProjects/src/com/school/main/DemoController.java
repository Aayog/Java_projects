package com.school.main;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class DemoController implements Initializable {

	@FXML
	private Circle user;

	@FXML
	private Label clockLable;

	@FXML
	private Label dateLable;

	@FXML
	private Label USER_NAME;

	@FXML
	private JFXButton buttonAdd;

	@FXML
	private JFXButton homeButton;

	@FXML
	private JFXButton studentButton;

	@FXML
	private JFXButton bookButton;

	@FXML
	private AnchorPane mainGround;

	AnchorPane addStudent = new AnchorPane();
	AnchorPane addResult = new AnchorPane();
	AnchorPane bookInfo = new AnchorPane();
	AnchorPane viewResult = new AnchorPane();
	AnchorPane homeView = new AnchorPane();

	@FXML
	void onPressStudentButton(ActionEvent event) {

		mainGround.getChildren().clear();
		mainGround.getChildren().add(addStudent);

	}

	@FXML
	void onPressAddResult(ActionEvent event) {

		try {
			addResult = FXMLLoader.load(getClass().getClassLoader().getResource("com/Add/Add.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		mainGround.getChildren().clear();
		mainGround.getChildren().add(addResult);
	}

	@FXML
	void onPressBook(ActionEvent event) {
		mainGround.getChildren().clear();
		mainGround.getChildren().add(bookInfo);
	}

	@FXML
	void onPressHome(ActionEvent event) {

	}

	@FXML
	void onPressViewResult(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		dateLable.setText(getDate());

		USER_NAME.setText("SAN LAMA");

		// TODO Auto-generated method stub

		try {
			addStudent = FXMLLoader.load(
					getClass().getClassLoader().getResource("com/addStudentRecord/ADD_STUDENT_RECORD_DASHBOARD.fxml"));
			bookInfo = FXMLLoader.load(getClass().getClassLoader().getResource("com/book/Book.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Image img = new Image("com/school/main/logo.jpg");
		user.setFill(new ImagePattern(img));

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Calendar time = Calendar.getInstance();
				String hourString = StringUtilities1.pad(2, ' ',
						time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
				String minuteString = StringUtilities1.pad(2, '0', time.get(Calendar.MINUTE) + "");
				String secondString = StringUtilities1.pad(2, '0', time.get(Calendar.SECOND) + "");
				String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
				clockLable.setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
			}
		}), new KeyFrame(Duration.seconds(1)));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();

	}

	private String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
		Date currentDate = new Date();
		return dateFormat.format(currentDate);
	}

}

class StringUtilities1 {
	/**
	 * Creates a string left padded to the specified width with the supplied padding
	 * character.
	 * 
	 * @param fieldWidth
	 *            the length of the resultant padded string.
	 * @param padChar
	 *            a character to use for padding the string.
	 * @param s
	 *            the string to be padded.
	 * @return the padded string.
	 */
	public static String pad(int fieldWidth, char padChar, String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i < fieldWidth; i++) {
			sb.append(padChar);
		}
		sb.append(s);

		return sb.toString();
	}
}
