package springcourse.springbook.repository;

import org.springframework.stereotype.Repository;
import springcourse.springbook.model.BookModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private final List<BookModel> books = new ArrayList<>();

    public void addBook(BookModel book) {
        books.add(book);
    }

    public List<BookModel> findAllBook() {
        return books;
    }

    public Optional<BookModel> findBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }
}
