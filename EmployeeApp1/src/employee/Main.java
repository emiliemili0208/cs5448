package employee;

import java.io.IOException;

import employee.model.Person;
import employee.view.ReviewOrderController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private static BorderPane mainLayout;
	private static BorderPane reviewLayout;

	//try
	private static BorderPane mainLayout1;
	//try

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Employee App");

		showMainView();
		showMainitems();


	}

	public void showMainView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void showMainitems() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/Mainitems.fxml"));
		BorderPane Mainitems = loader.load();
		mainLayout.setCenter(Mainitems);

	}

	public static void showReviewOrder() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/ReviewOrder.fxml"));
		BorderPane ReviewOrder = loader.load();
		mainLayout.setCenter(ReviewOrder);


		//setting controller to the button
        ReviewOrderController controller = loader.getController();
        controller.setMainApp(controller);

	}



	//new code for table data
	//new changed
	//private ObservableList<Person> personData = FXCollections.observableArrayList();

    public Main() {
        // Add some sample data
        /*personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));*/
    }

    //new changed
    /*public ObservableList<Person> getPersonData() {
        return personData;
    }
*/




//new changed
   /* public void showReviewOrderOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("revieworder/ReviewOrder.fxml"));
            AnchorPane ReviewOrder = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            mainLayout.setCenter(ReviewOrder);

            // Give the controller access to the main app.
            ReviewOrderController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/




	public static void main(String[] args) {
		launch(args);
	}
}
