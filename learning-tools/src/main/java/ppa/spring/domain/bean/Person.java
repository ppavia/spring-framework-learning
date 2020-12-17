package ppa.spring.domain.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Address> addresses = new HashSet<>();

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_person"
    )
    @SequenceGenerator(
            name = "seq_person",
            allocationSize = 5
    )
    private long id;

    /**
     * Add new address for this person.
     * Used to synchronize both sides of bidirectional association.
     *
     * @param address
     */
    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setPerson(this);
    }

    /**
     * Remove address for this person.
     * Used to synchronize both sides of bidirectional association.
     *
     * @param address
     */
    public void removeAddress(Address address) {
        this.addresses.remove(address);
        address.setPerson(null);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
