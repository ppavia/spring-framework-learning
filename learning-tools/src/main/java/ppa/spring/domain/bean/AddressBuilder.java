package ppa.spring.domain.bean;

public class AddressBuilder {
    private String nameStreet;
    private String complementStreet;
    private String numStreet;
    private String zipCode;
    private String city;
    private Person person;

    public AddressBuilder nameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
        return this;
    }

    public AddressBuilder complementStreet(String complementStreet) {
        this.complementStreet = complementStreet;
        return this;
    }

    public AddressBuilder numStreet(String numStreet) {
        this.numStreet = numStreet;
        return this;
    }

    public AddressBuilder zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder person(Person person) {
        this.person = person;
        return this;
    }

    public Address createAddress() {
        return new Address(nameStreet, complementStreet, numStreet, zipCode, city, person);
    }
}