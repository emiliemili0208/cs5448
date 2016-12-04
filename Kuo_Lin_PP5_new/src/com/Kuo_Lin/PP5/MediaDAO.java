package com.Kuo_Lin.PP5;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

public class MediaDAO {

	private Session session;
	
	public MediaDAO(Session session) {
		this.session = session;
	}
	
	public void createBook(String title, String author) {
		session.save(new Book(title, author));
	}
	
	public void createDVD(String title, int year) {
		session.save(new DVD(title, year));
	}
	
	public void queryBook(){
		String hql = "FROM com.Kuo_Lin.PP5.Book";
		List results = new ArrayList<Book>();
		results = session.createQuery(hql).getResultList();

		for ( Book tmpbook : (List<Book>) results ) {
		    System.out.println( tmpbook );
		}
	}
	
	public void queryDVD(){
		String hql = "FROM com.Kuo_Lin.PP5.DVD";
		List results = session.createQuery(hql).getResultList();

		for ( DVD tmpdvd : (List<DVD>) results ) {
		    System.out.println( tmpdvd );
		}
	}
}
