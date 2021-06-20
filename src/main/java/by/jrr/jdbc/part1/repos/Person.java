/*
package by.jrr.jdbc.part1.repos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private IDCard idCard;

    public Person(String name, IDCard idCard) {
        this.name = name;
        this.idCard = idCard;
        this.idCard.setPerson(this);
    }

    public Person() {
    }
}
*/
