package springcourse.springbook.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reader {
    private int id;
    private String name;
    private int maxBooks;
}
