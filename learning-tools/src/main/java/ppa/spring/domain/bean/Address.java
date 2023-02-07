package ppa.spring.domain.bean;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
@DiscriminatorValue("address")
public class Address extends Location {
    private String nameStreet;
    private String complementStreet;
    private String numStreet;
    private String zipCode;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public String getComplementStreet() {
        return complementStreet;
    }

    public void setComplementStreet(String complementStreet) {
        this.complementStreet = complementStreet;
    }

    public String getNumStreet() {
        return numStreet;
    }

    public void setNumStreet(String numStreet) {
        this.numStreet = numStreet;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(this.id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
