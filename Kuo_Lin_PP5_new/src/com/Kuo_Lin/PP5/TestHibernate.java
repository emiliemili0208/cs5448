/*Yi-Chen Kuo, Chih-Wei Lin*/
package com.Kuo_Lin.PP5;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestHibernate {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		try {
			setUp();
		} catch (Exception e) {
			System.out.println("Something went wrong with setUp!" + e);
		}

		if (sessionFactory == null) {
			System.out.println("sessionFactory is null");
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		MediaDAO book = new MediaDAO(session);
		book.createBook("Dare to go Solo", "Elizabeth Boese");
		book.createBook("Intro to Programming with Java Applets", "Liz Boese");
		
		MediaDAO dvd = new MediaDAO(session);
		book.createDVD("Dare to go Solo", 2006);
		dvd.createDVD("Intro to Programming", 1970);
		
		book.queryBook();
		dvd.queryDVD();
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("success");
	}

	protected static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		// configures settings from hibernate.cfg.xml
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		try {
			sessionFactory = new MetadataSources(registry).addAnnotatedClass(Media.class).buildMetadata()
					.buildSessionFactory();
			
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			System.out.println("Something went wrong with setUp!" + e);
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
};
