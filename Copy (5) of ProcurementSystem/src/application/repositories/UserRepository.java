package application.repositories;

import java.util.List;

import application.models.Facility;
import application.models.User;

public interface UserRepository {
	User findUser(String email, String password);
	List<Facility> getFacilities();
}
