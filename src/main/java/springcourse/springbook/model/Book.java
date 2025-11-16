package springcourse.springbook.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private String genre;
    private boolean available;
}
