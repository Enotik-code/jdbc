package by.logistics.bean;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "status_id")
    private int id;

    @Column(name = "status_name", unique=true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "status", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Company> companies;

    public Status(String name) {
        this.name = name;
    }
}

