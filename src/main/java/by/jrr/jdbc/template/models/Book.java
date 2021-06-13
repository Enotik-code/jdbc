package by.jrr.jdbc.template.models;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String isbn;
    private String author;
    private String title;
    private String synopsis;
    private String language;
}