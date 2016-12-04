package application.ui.controllers;

import application.models.Order;
import application.repositories.OrderRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class OrderDetailsController extends BaseController {
	private OrderRepository orderRepository;
	
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@FXML
	private Label itemLabel;
	@FXML
	private Label createdDateLabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label quantityLabel;
	@FXML
	private Label facilityLabel;
	@FXML
	private Label roomLabel;
	@FXML
	private Label justificationLabel;
	@FXML
	private Button cancelButton;
	@FXML
	private HBox buttonBox;

	
	@Override
	public void onLoad() {
		Order order = applicationController.getCurrentOrder();
		copyDataToControls(order);
		
		if (!order.isCancelableByUser(getCurrentUser())) {
			buttonBox.getChildren().remove(cancelButton);
		}
	}

	private void copyDataToControls(Order order) {
		itemLabel.setText(order.getItem().toString());
		createdDateLabel.setText(order.getCreatedDate().toString());
		descriptionLabel.setText(order.getDescription());
		quantityLabel.setText(Integer.toString(order.getQuantity()));
		facilityLabel.setText(order.getFacility().toString());
		roomLabel.setText(order.getRoom());
		justificationLabel.setText(order.getJustification());
	}

	@FXML
	private void goToListScreen() {
		applicationController.loadMenuedScreen("/application/ui/views/MyOrders.fxml");
	}
	
	@FXML
	private void cancelOrder() {
		Order currentOrder = applicationController.getCurrentOrder();
		orderRepository.cancelOrder(currentOrder.getId());
		applicationController.loadMenuedScreen("/application/ui/views/MyOrders.fxml");
	}
}
