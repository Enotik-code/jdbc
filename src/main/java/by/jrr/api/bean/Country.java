package by.jrr.api.bean;

import lombok.Data;

@Data
public class Country {
    private String code;
    private String name;
    private String currency;
    private NameTranslations nameTranslations;
}
