package se.jola.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String username;

    @Column(nullable = true)
    private String password;

    protected User() {
    }

    public User(String firstName, String lastName, String username) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
    }

    public User setFirstName(String firstName) {
	this.firstName = firstName;

	return this;
    }

    public User setLastName(String lastName) {
	this.lastName = lastName;

	return this;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public String getUsername() {
	return username;
    }

    public String getPassword() {
	return password;
    }
    
    public Long getId() {
	return id;
    }

    @Override
    public String toString() {

	return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
