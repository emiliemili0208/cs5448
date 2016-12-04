package application.ui.controllers;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MainMenuController extends BaseController {
	@FXML
	private MenuBar menuBar;
	@FXML
	private Menu managerMenu;
	@FXML
	private Menu procurementOfficerMenu;
	@FXML
	private Menu procurementManagerMenu;

	@Override
	public void onLoad() {
		if (!getCurrentUser().hasRole("Manager")) {
			menuBar.getMenus().remove(managerMenu);
		}

		if (!getCurrentUser().hasRole("Procurement Officer")) {
			menuBar.getMenus().remove(procurementOfficerMenu);
		}

		if (!getCurrentUser().hasRole("Procurement Manager")) {
			menuBar.getMenus().remove(procurementManagerMenu);
		}
	}

	@FXML
	private void loadCreateOrderScreen() {
		applicationController.setCurrentOrder(null);
		applicationController.loadMenuedScreen("/application/ui/views/CreateOrder.fxml");
	}

	@FXML
	private void loadMyOrdersScreen() {
		applicationController.loadMenuedScreen("/application/ui/views/MyOrders.fxml");
	}

	@FXML
	private void loadProcessOrderScreen() {
		applicationController.loadMenuedScreen("/application/ui/views/ProcessOrder.fxml");
	}

	@FXML
	private void loadReviewOrdersScreen() throws IOException {
		applicationController.loadMenuedScreen("/application/ui/views/PersonOverview.fxml");
	}

}
