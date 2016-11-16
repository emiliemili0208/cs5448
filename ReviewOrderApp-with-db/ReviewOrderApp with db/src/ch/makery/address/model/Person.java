package ch.makery.address.model;

import java.time.LocalDate;

import javax.swing.Spring;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty id;
    private final StringProperty reviewOrder;


    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, 0, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName, int id, String reviewOrder) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.reviewOrder = new SimpleStringProperty(reviewOrder);
        this.id = new SimpleStringProperty(Integer.toString(id));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getReviewOrder() {
        return reviewOrder.get();
    }

    public String getid() {
        return id.get();
    }

    public void setid(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }
}