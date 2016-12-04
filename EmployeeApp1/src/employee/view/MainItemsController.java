package employee.view;

import java.io.IOException;

import employee.Main;
import employee.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MainItemsController {
	private Main main;



	@FXML
	private void goReviewOrder() throws IOException{
		main.showReviewOrder();
		//new code
		//main.showReviewOrderOverview1();
	}

	//new code

}