package application.ui.controllers;

import java.util.List;

import application.models.Order;
import application.repositories.OrderRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyOrdersController extends BaseController {
	private OrderRepository orderRepository;
	
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@FXML
	private TableView<Order> orderTable;
	@FXML
	private TableColumn<Order, String> itemColumn;
	@FXML
	private TableColumn<Order, String> quantityColumn;
	@FXML
	private TableColumn<Order, String> statusColumn;
	@FXML
	private TableColumn<Order, String> deliveryColumn;
	@FXML
	private TableColumn<Order, String> justificationColumn;
	
	@Override
	public void onLoad() {		      
		itemColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("item"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));
		deliveryColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("expectedDeliveryString"));
		justificationColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("justification"));
		
		List<Order> orders = orderRepository.getOrdersForEmployee(getCurrentUser());
		orderTable.setItems(FXCollections.observableArrayList(orders));
	}
	
	@FXML
	private void selectOrder() {
		Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
		applicationController.setCurrentOrder(selectedOrder);
		if (selectedOrder.isEditableByUser(getCurrentUser())) {
			applicationController.loadMenuedScreen("/application/ui/views/CreateOrder.fxml");
		} else {
			applicationController.loadMenuedScreen("/application/ui/views/OrderDetails.fxml");
		}
	}
}
