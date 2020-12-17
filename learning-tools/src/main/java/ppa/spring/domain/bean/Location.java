package ppa.spring.domain.bean;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_address")
public abstract class Location {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_location"
    )
    @SequenceGenerator(
            name = "seq_location",
            allocationSize = 5
    )
    protected long id;

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
