package se.jola.exceptions;

public class RepositoryException extends Exception {

    private static final long serialVersionUID = 6711071298983425290L;
    
    public RepositoryException(String message){
	super(message);
    }
    

    public RepositoryException(String message, Exception e){
	super(message, e);
    }

}
