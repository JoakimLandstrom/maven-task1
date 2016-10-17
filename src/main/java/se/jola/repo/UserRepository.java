package se.jola.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.jola.entities.User;

public class UserRepository {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

    private EntityManager manager;

    private EntityManager getManager() {
	return FACTORY.createEntityManager();
    }

    public void saveUser(User user) {

	manager = getManager();

	manager.getTransaction().begin();;

	manager.persist(user);

	manager.getTransaction().commit();

	manager.close();
    }
    
    public void getUser(User user){
	
    }
    
    

}
