package se.jola.main;

import java.util.ArrayList;
import java.util.List;

import se.jola.entities.User;
import se.jola.exceptions.RepositoryException;
import se.jola.repo.UserRepository;

public class Main {

    private static UserRepository userRepository = new UserRepository();
    
    public static void main(String[] args) {
	
	User user = new User("joakim", "landstrom", "joakimlandstrom");
	List<User> userList = new ArrayList<>();
	
	try {
	    userRepository.saveUser(user);
	} catch (RepositoryException e) {
	    e.printStackTrace();
	}
	
	try{
	    userRepository.updateUser(user.setFirstName("räva").setLastName("baby"));
	}catch (RepositoryException e) {
	   e.printStackTrace();
	}
	
	try{
	   userList = userRepository.getAllUsers();
	    
	}catch (Exception e) {
	   e.printStackTrace();
	}
	System.out.println(userList.toString());
	
    }
    
}
