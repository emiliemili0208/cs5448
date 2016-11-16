package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;


public class QueryEmployeeDemo {
	private List<Employee> theEmployees;

	public List<Employee> getTheEmployees() {
		return theEmployees;
	}

	public void queryEmployee() {
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();


		// create session
		Session session = factory.getCurrentSession();

		try{

			//start a transaction
			session.beginTransaction();

			// query students
			theEmployees = session.createQuery("from Employee").list();

			//display the students
			for (Employee tempEmployee : theEmployees){

				System.out.println(tempEmployee);
			}
			//System.out.println("Student who have last name of DOE");
			//displayStudents(theStudents);

			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		}
		finally{
			factory.close();
		}

	}


}
