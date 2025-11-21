package springcourse.springbook.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    private int id;
    private int readerId;
    private int bookId;
    private LocalDate loanDate;
    private LocalDate returnDate;
}
