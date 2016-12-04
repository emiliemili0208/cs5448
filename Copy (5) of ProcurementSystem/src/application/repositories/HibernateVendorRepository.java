package application.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import application.models.Vendor;

@Transactional
public class HibernateVendorRepository implements VendorRepository {
	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public List<Vendor> getVendors() {
		String hql = "FROM Vendor v ORDER BY v.name";
		@SuppressWarnings("unchecked")
		TypedQuery<Vendor> query = sessionFactory.getCurrentSession().createQuery(hql);
	    return query.getResultList();
	}

	@Override
	public void saveVendor(Vendor vendor) {
		sessionFactory.getCurrentSession().saveOrUpdate(vendor);
	}
}
