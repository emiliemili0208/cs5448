package application.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import application.models.Order;
import application.models.User;
import application.models.status.OrderStatus;
import application.ui.controllers.PersonOverviewController;

@Transactional
public class HibernateOrderRepository implements OrderRepository {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<Order> getOrdersForEmployee(User employee) {
		String hql = "FROM Order o JOIN FETCH o.item i JOIN FETCH i.category JOIN FETCH o.facility JOIN FETCH o.employee e WHERE e.id = :employeeId";
		@SuppressWarnings("unchecked")
		TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("employeeId", employee.getId());
	    return query.getResultList();
	}

	@Override
	public List<Order> getApprovedOrders() {
		String hql = "FROM Order o WHERE o.status = :status";
		@SuppressWarnings("unchecked")
		TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("status", OrderStatus.APPROVED);
	    return query.getResultList();
	}

	@Override
	public void saveOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override
	public void cancelOrder(int orderId) {
		Session session = sessionFactory.getCurrentSession();
		Order order = (Order)session.get(Order.class, orderId);
		order.setStatus(OrderStatus.CANCELED);
		session.update(order);
	}

	@Override
	public List<Order> getOrderForReview(User manager) {
		String hql = "FROM Order o JOIN FETCH o.item i JOIN FETCH i.category JOIN FETCH o.facility JOIN FETCH o.employee e JOIN FETCH e.manager m WHERE m.id = :managerId AND o.status = :status";
		@SuppressWarnings("unchecked")
		TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("managerId", manager.getId());
		query.setParameter("status", OrderStatus.SUBMITTED);
	    return query.getResultList();
	}

	private List<Order> theEmployees;


	@Override
	public List<Order> getTheEmployees() {
		return theEmployees;
	}

	@Override

	public void queryEmployee() {
		Session session = sessionFactory.getCurrentSession();
			//theEmployees = session.createQuery("from Employee e where e.status = 'none'").list();
			//theEmployees = session.createQuery("FROM Order o FETCH JOIN o.employee e where e.status = 'none'").list();
			theEmployees = session.createQuery("from Order o where o.status = 'Submitted'").list();
			for (Order tempEmployee : theEmployees){

				System.out.println(tempEmployee);
			}

			System.out.println("Done!");
	}

	@Override
	public void Approved() {
		Session session = sessionFactory.getCurrentSession();

			String employeeId = PersonOverviewController.getCurrent_id() ;

			session = sessionFactory.getCurrentSession();


			System.out.println("\nGetting employee with id: " + employeeId);

			Order myEmployee = session.get(Order.class, Integer.valueOf(employeeId));

			System.out.println("Updating employee...");
			myEmployee.setStatus("Approved");

	}

	@Override
	public void Rejected() {
		Session session = sessionFactory.getCurrentSession();

			String employeeId = PersonOverviewController.getCurrent_id() ;

			session = sessionFactory.getCurrentSession();


			System.out.println("\nGetting employee with id: " + employeeId);

			Order myEmployee = session.get(Order.class, Integer.valueOf(employeeId));

			System.out.println("Updating employee...");
			myEmployee.setStatus("Rejected");



	}

}
