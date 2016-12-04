/*Yi-Chen Kuo, Chih-Wei Lin*/
package com.Kuo_Lin.PP5;

import javax.persistence.*;

@Entity
@Table(name="Kuo_Lin_DVD")
@PrimaryKeyJoinColumn(name="dvd_id") 
public class DVD extends Media {

	@Column(name = "year")  
	private int year;
	
	public DVD() {
		super();
	}
    public DVD(String title, int year)
    {
        this.title = title;
        this.year = year;
    }
	public int getYear() 	 { return year;  }
    public String toString()
    {
        return year + ": " + title + " [DVD]";
	}
    
    
}
