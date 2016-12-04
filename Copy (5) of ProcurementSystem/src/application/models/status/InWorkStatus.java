package application.models.status;

import application.models.Order;
import application.models.User;

public class InWorkStatus extends OrderStatus {

	@Override
	public boolean canBeEditedByUser(Order order, User user) {
		return user.getId() == order.getEmployee().getId();
	}
	
	@Override
	public boolean canBeCanceledByUser(Order order, User user) {
		return user.getId() == order.getEmployee().getId();
	}

}
