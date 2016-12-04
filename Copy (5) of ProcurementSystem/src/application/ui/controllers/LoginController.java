package application.ui.controllers;

import application.models.User;
import application.repositories.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends BaseController {
	private UserRepository userRepository;
	
	@FXML
	private TextField email;
	@FXML
	private PasswordField password;

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@FXML
	private void login() {
		User user = userRepository.findUser(email.getText(), password.getText());
		if (user == null) {
			password.setText("");
			showError("Invalid Login", "The email and password you entered were not recognized. Please try again.");
		} else {
			applicationController.setCurrentUser(user);
			applicationController.loadMenuedScreen("/application/ui/views/Welcome.fxml");
		}
	}
}
