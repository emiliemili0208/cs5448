package application.ui.controllers;

import java.sql.Date;

import application.models.User;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class BaseController {
	protected ApplicationController applicationController;

	public void setApplicationController(ApplicationController applicationController) {
		this.applicationController = applicationController;
	}

	public User getCurrentUser() {
		return applicationController.getCurrentUser();
	}
	
	public void onLoad() {}
	
	protected void showError(String header, String text) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(header);
		alert.setContentText(text);
		alert.showAndWait();
	}
	
	protected java.sql.Date getCurrentDate() {
		java.util.Date currentDate = new java.util.Date();
		return new java.sql.Date(currentDate.getTime());
	}
}
