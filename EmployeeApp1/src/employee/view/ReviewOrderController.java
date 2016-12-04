package employee.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import employee.Main;
import employee.model.Person;
import employee.Main;

public class ReviewOrderController extends Application {
	//new code
	private static BorderPane ReviewOrder;

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label orderLabel;
    /*@FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;*/

    // Reference to the main application.
    private ReviewOrderController main;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public ReviewOrderController() {
    }

	   /*public void showReviewOrderOverview() {
	        try {
	            // Load person overview.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(Main.class.getResource("ReviewOrder.fxml"));
	            BorderPane ReviewOrder = (BorderPane) loader.load();

	            // Set person overview into the center of root layout.
	            ReviewOrder.setCenter(ReviewOrder);

	            // Give the controller access to the main app.
	            ReviewOrderController controller = loader.getController();
	            controller.setMainApp(this);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }*/


/////
    /*public void showPersonOverview() {
        try {

            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ReviewOrderController.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            ReviewOrder.setCenter(personOverview);

            // Give the controller access to the main app.
            ReviewOrderController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    //new changed
    private ObservableList<Person> personData = FXCollections.observableArrayList();{
    	personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));



    }

    public void setMainApp(ReviewOrderController reviewOrderController) {
        this.main = reviewOrderController;

        // Add observable list data to the table
        personTable.setItems(getPersonData());

    }



    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            orderLabel.setText(person.getOrder());


            // TODO: We need a way to convert the birthday into a String!
            // birthdayLabel.setText(...);
        } else {
            // Person is null, remove all the text.
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            orderLabel.setText("");

        }
    }




/////
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

	}


}