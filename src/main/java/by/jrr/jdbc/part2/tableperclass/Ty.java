package by.jrr.jdbc.part2.tableperclass;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ty {
    @Id
    private long tyId;
    private String name;
}
