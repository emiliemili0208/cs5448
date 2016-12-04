package application.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import application.models.ItemCategory;

@Transactional
public class HibernateItemRepository implements ItemRepository {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<ItemCategory> getCategories() {
    	String hql = "SELECT DISTINCT c FROM ItemCategory c JOIN FETCH c.items ORDER BY c.name";
		@SuppressWarnings("unchecked")
		TypedQuery<ItemCategory> query = sessionFactory.getCurrentSession().createQuery(hql);
	    return query.getResultList();
    }
}
