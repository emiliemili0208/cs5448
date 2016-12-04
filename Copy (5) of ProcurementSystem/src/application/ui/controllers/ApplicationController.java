package application.ui.controllers;

import java.io.IOException;

import org.springframework.context.ApplicationContext;

import application.models.Order;
import application.models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ApplicationController {
	private ApplicationContext context;
	private Stage stage;
	private User currentUser;
	private Order currentOrder;
	
	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public ApplicationController(ApplicationContext context, Stage stage) {
		this.context = context;
		this.stage = stage;
	}
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public Scene loadMenuedScreen(String viewFilename) {
		Scene scene = null;
		try {
			scene = loadScreen(viewFilename);
			MenuBar menu = loadFXMLComponent("/application/ui/views/MainMenu.fxml");
		    BorderPane pane = (BorderPane) scene.getRoot();
		    pane.setTop(menu);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return scene;
	}
	
	public Scene loadScreen(String viewFilename) {
		Scene scene = null;
		try {
			scene = loadFXMLComponent(viewFilename);
		    scene.getStylesheets().add(getClass().getResource("../views/application.css").toExternalForm());
			stage.setScene(scene);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return scene;
	}
	
	private <T> T loadFXMLComponent(String fxmlFilename) throws IOException {
		FXMLLoader componentLoader = new FXMLLoader(getClass().getResource(fxmlFilename));
		componentLoader.setControllerFactory(new Callback<Class<?>, Object>() {
			
			@Override
			public Object call(Class<?> param) {
				return context.getBean(param.getSimpleName());
			}
		});
	    T component = componentLoader.load();
	    BaseController controller = componentLoader.getController();
	    controller.setApplicationController(this);
	    controller.onLoad();
	    return component;
	}
}
