package application.repositories;

import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import application.models.Facility;
import application.models.User;

@Transactional
public class HibernateUserRepository implements UserRepository {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public User findUser(String email, String password) {
		String hql = "FROM User u JOIN FETCH u.roles WHERE u.email = :email AND u.password = :password";
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);
	    List<User> results = query.getResultList();
	    if (results.size() == 0) return null;
	    return results.get(0);
	}
	
	@Override
	public List<Facility> getFacilities() {
		String hql = "FROM Facility f ORDER BY f.name";
		@SuppressWarnings("unchecked")
		TypedQuery<Facility> query = sessionFactory.getCurrentSession().createQuery(hql);
	    return query.getResultList();
	}
}
