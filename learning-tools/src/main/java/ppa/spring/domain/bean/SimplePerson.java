package ppa.spring.domain.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "SIMPLEPERSON")
public class SimplePerson {

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public SimplePerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SimplePerson(Long id) {
        this.id = id;
    }

    public SimplePerson() {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
