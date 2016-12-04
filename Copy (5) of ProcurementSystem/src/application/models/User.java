package application.models;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String email;
	private String password;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="user_role", 
				joinColumns={@JoinColumn(name="user_id")}, 
				inverseJoinColumns={@JoinColumn(name="role_id")})
	private Set<Role> roles = new HashSet<Role>();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="manager_id")
	private User manager;
	
	
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public String getRolesDescription() {
		if (roles.size() == 0) return "Employee";
		return roles.stream()
			  .map(Role::getName)
			  .collect(Collectors.joining(", "));
	}
	public boolean hasRole(String roleName) {
		return roles.stream()
			  .anyMatch(role -> role.getName().equals(roleName));
	}
	public String toString() {
		return firstName + " " + lastName;
	}
}
