package by.jrr.jdbc.part2.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1_Book")
public class Book extends MyProduct{
    private String author;

    public Book() {
    }

    public Book(long productId, String name, String author) {
        super(productId, name);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
