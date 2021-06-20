/*
package by.jrr.jdbc.part1.repos;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class IDCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "person_id")
    @MapsId
    @PrimaryKeyJoinColumn(name = "id")
    private Person person;

    @Column(unique = true, nullable = false)
    private String code = UUID.randomUUID().toString();
}
*/
