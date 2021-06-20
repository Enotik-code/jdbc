package by.jrr.jdbc.part1.repos.parents;

import lombok.ToString;

@ToString(callSuper = true, includeFieldNames = true)
public class Dochka extends Rodetel {
    private String asd;
    private String asd2;

    public Dochka(int adas) {
        super(adas);
    }

}
