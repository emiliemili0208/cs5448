package application.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WelcomeController extends BaseController {
	@FXML
	private Label greeting;
	
	@Override
	public void onLoad() {
		String greetingText = "You are logged in as " + getCurrentUser().getFirstName() + " " + getCurrentUser().getLastName() + 
				".\nYou have the following roles: " + getCurrentUser().getRolesDescription() + 
				".\nPlease select a menu item to continue.";
		greeting.setText(greetingText);
	}
}
