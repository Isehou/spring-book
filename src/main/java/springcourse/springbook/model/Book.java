package springcourse.springbook.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String genre;
    private boolean available = true;

}
