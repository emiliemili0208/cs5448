/*Yi-Chen Kuo, Chih-Wei Lin*/
package com.Kuo_Lin.PP5;
import javax.persistence.*;


@Entity
@Table(name="Kuo_Lin_Media")
@Inheritance(strategy=InheritanceType.JOINED)  
public class Media {
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "media_id")  
	protected int id;
	
	@Column(name = "title")  
	protected String title;
	
	public Media() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle()  
	{ return title; }
}
