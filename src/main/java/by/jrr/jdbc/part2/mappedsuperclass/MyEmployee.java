package by.jrr.jdbc.part2.mappedsuperclass;


import javax.persistence.Entity;

@Entity
public class MyEmployee extends Person {
    private String company;

    public MyEmployee(long personId, String name, String company) {
        super(personId, name);
        this.company = company;
    }

    public MyEmployee() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
