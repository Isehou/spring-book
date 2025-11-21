package springcourse.springbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springcourse.springbook.model.Book;
import springcourse.springbook.model.Loan;
import springcourse.springbook.model.Reader;
import springcourse.springbook.repository.BookRepository;
import springcourse.springbook.repository.LoanRepository;
import springcourse.springbook.repository.ReaderRepository;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoanService {
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    private final ReaderRepository readerRepo;

    public Loan issueBook(int readerId, int bookId) {

        Book book = bookRepo.findById(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        if (!book.isAvailable()) {
            throw new IllegalArgumentException("Book is not available");
        }

        Reader reader = readerRepo.findById(readerId);
        if (reader == null) {
            throw new IllegalArgumentException("Reader not found");
        }

        long currentIssued = loanRepo.findAll().stream()
                .filter(l -> l.getReaderId() == readerId && l.getReturnDate() == null)
                .count();

        if (currentIssued >= reader.getMaxBooks()) {
            throw new IllegalStateException(
                    "Reader exceeded max book limit: " + reader.getMaxBooks()
            );
        }

        long booksInUse = loanRepo.findAll().stream()
                .filter(l -> l.getReaderId() == readerId && l.getReturnDate() == null)
                .count();

        if(booksInUse >= reader.getMaxBooks()) {
            throw new RuntimeException("Books limit exceeded");
        }

        Loan loan = Loan.builder()
                .readerId(readerId)
                .bookId(bookId)
                .loanDate(LocalDate.now())
                .returnDate(null)
                .build();

        loanRepo.save(loan);

        book.setAvailable(false);
        bookRepo.save(book);

        return loan;
    }

    public Loan returnBook(int readerId, int bookId) {

        Loan loan = loanRepo.findAll().stream()
                .filter(l -> l.getBookId() == bookId && l.getReturnDate() == null)
                .findFirst()
                .orElse(null);

        if (loan == null) {
            throw new RuntimeException("Book not found");
        }
    }
}
