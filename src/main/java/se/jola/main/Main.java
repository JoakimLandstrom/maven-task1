package se.jola.main;

import java.util.ArrayList;
import java.util.List;

import se.jola.entities.User;
import se.jola.exceptions.RepositoryException;
import se.jola.repo.UserRepository;

public class Main {

    private static UserRepository userRepository = new UserRepository();
    
    public static void main(String[] args) {
	
	List<User> userList = new ArrayList<>();
	User user = new User("Joakim", "landstorm", "joakimlandstrom"); 
	
	try{
	    
	    userRepository.saveUser(user);
	    
	}catch (Exception e) {
	   e.printStackTrace();
	}
	
	try{
	    userList = userRepository.getAllUsers();
	    
	    user = userList.get(0);
	    
	}catch (Exception e) {
	    e.printStackTrace();
	}
	
	try{
	    userRepository.updateUser(user.setFirstName("räva").setLastName("baby"));
	}catch (RepositoryException e) {
	   e.printStackTrace();
	}
	
	System.out.println(userList.toString());
	
    }
    
}
