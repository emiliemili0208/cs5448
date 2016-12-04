package application.ui.controllers;

import java.util.List;
import application.models.Order;
import application.repositories.OrderRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProcessOrderController extends BaseController {
	private OrderRepository orderRepository;
	
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@FXML
	private TableView<Order> orderTable;
	@FXML
	private	TableColumn<Order, String> idColumn;
	@FXML
	private	TableColumn<Order, String> employeeColumn;
	@FXML
	private TableColumn<Order, String> itemColumn;
	@FXML
	private TableColumn<Order, String> quantityColumn;
	@FXML
	private TableColumn<Order, String> totalColumn;
	@FXML
	private TableColumn<Order, String> facilityColumn;
	@FXML
	private TableColumn<Order, String> roomColumn;
	@FXML
	private TableColumn<Order, String> statusColumn;

	@Override
	public void onLoad() {
		idColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("id"));
		itemColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("item"));
		employeeColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("employee"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("quantity"));
		totalColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("total"));
		facilityColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("facility"));
		roomColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("room"));
		statusColumn.setCellValueFactory(new PropertyValueFactory<Order, String>("status"));

		List<Order> orders = orderRepository.getApprovedOrders();
		orderTable.setItems(FXCollections.observableArrayList(orders));
	}

	@FXML
	private void selectOrder() {
		Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
		applicationController.setCurrentOrder(selectedOrder);
		applicationController.loadMenuedScreen("/application/ui/views/EditOrder.fxml");
	}
}
