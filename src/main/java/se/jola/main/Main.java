package se.jola.main;

import se.jola.entities.User;
import se.jola.repo.UserRepository;

public class Main {

    private static UserRepository userRepository = new UserRepository();
    
    public static void main(String[] args) {
	
	User user = new User("joakim", "landstrom", "joakimlandstrom");
	
	userRepository.saveUser(user);
	
    }
    
}
