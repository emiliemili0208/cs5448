package application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import application.ui.controllers.ApplicationController;
import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {
	private ApplicationController applicationController;
	private ClassPathXmlApplicationContext context;

	@Override
	public void start(Stage primaryStage) {

		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			applicationController = new ApplicationController(context, primaryStage);
			applicationController.loadScreen("/application/ui/views/Login.fxml");
			primaryStage.setTitle("EZProcure");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void stop() throws Exception {
		super.stop();
		context.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}