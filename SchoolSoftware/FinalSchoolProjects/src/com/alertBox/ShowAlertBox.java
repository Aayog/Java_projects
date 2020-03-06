package com.alertBox;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ShowAlertBox {

	Alert typeAlert = new Alert(AlertType.NONE);

	public void showAlert(String mode, String message, String title) {

		if (mode.equals("I")) {
			typeAlert.setAlertType(AlertType.INFORMATION);
		} else if (mode.equals("W")) {
			typeAlert.setAlertType(AlertType.WARNING);
		} else if (mode.equals("E")) {
			typeAlert.setAlertType(AlertType.ERROR);
		} else if (mode.equals("C")) {
			typeAlert.setAlertType(AlertType.CONFIRMATION);
		} else {
			typeAlert.setAlertType(AlertType.WARNING);
		}
		typeAlert.setTitle(title);
		typeAlert.setContentText(message);
		typeAlert.showAndWait();

	}
}
