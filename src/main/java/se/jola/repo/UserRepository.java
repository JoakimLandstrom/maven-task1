package se.jola.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import se.jola.entities.User;
import se.jola.exceptions.RepositoryException;

public class UserRepository {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

    private EntityManager manager;

    private EntityManager getManager() {
	return FACTORY.createEntityManager();
    }

    public void saveUser(User user) throws RepositoryException {

	try {
	    manager = getManager();

	    manager.getTransaction().begin();

	    manager.persist(user);

	    manager.getTransaction().commit();

	} catch (PersistenceException e) {
	    manager.getTransaction().rollback();
	    throw new RepositoryException("Couldnt save user:" + user.toString());
	} finally {
	    manager.close();
	}

    }

    public User getUser(Long id) throws RepositoryException {

	User user;

	try {
	    manager = getManager();

	    user = manager.find(User.class, id);

	} catch (PersistenceException e) {
	    throw new RepositoryException("");
	} finally {
	    manager.close();
	}

	return user;
    }

    public List<User> getAllUsers() throws RepositoryException {

	List<User> userList = new ArrayList<>();

	try {
	    manager = getManager();

	    Query query = manager.createQuery("SELECT u FROM User u", User.class);

	    userList = query.getResultList();

	} catch (PersistenceException e) {
	    throw new RepositoryException("");
	} finally {
	    manager.close();
	}
	return userList;
    }

    public void updateUser(User user) throws RepositoryException {

	try {
	    manager = getManager();

	    manager.getTransaction().begin();

	    User returnedUser = manager.find(User.class, user.getId());

	    returnedUser.setFirstName(user.getFirstName());
	    returnedUser.setLastName(user.getLastName());

	    manager.getTransaction().commit();

	} catch (PersistenceException e) {
	    manager.getTransaction().rollback();
	    throw new RepositoryException("");
	} finally {
	    manager.close();
	}

    }

}
