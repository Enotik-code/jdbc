package by.jrr.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private String author;
    private String country;
    @Column(name = "count_of_pages")
    private int countOfPages;

    public Book(String name, String author, String country, int countOfPages) {
        this.name = name;
        this.author = author;
        this.country = country;
        this.countOfPages = countOfPages;
    }

    public Book() {
    }
}
