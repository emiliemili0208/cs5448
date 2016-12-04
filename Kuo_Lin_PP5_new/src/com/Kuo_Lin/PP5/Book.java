/*Yi-Chen Kuo, Chih-Wei Lin*/
package com.Kuo_Lin.PP5;

import javax.persistence.*;

@Entity
@Table(name="Kuo_Lin_Book")
@PrimaryKeyJoinColumn(name="book_id") 
public class Book extends Media{
	
	@Column(name="author")
	 private String author;
	
		public Book()
	    {
	        super();
	        this.author="";
	    }
	    public Book(String title, String author)
	    {
	        this.title = title;
	        this.author = author;
	    }
	    
		public void setAuthor(String author) {
			this.author = author;
		}
		
		public String getAuthor() { return author; }
	    public String toString()
	    {
	        return getTitle() + " by " + getAuthor();
		}
	   
}
