package by.jrr.jdbc.part2.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2_Pen")
public class Pen extends MyProduct{
    private String color;

    public Pen() {
    }

    public Pen(long productId, String name, String color) {
        super(productId, name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
