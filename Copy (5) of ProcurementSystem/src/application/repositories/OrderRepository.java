package application.repositories;

import java.util.List;

import application.models.Order;
import application.models.User;

public interface OrderRepository {
	List<Order> getOrdersForEmployee(User employee);
	List<Order> getApprovedOrders();
	void saveOrder(Order order);
	void cancelOrder(int orderId);
	List<Order> getOrderForReview(User manager);

	List<Order> getTheEmployees();
	void queryEmployee();
	void Approved();
	void Rejected();
}
