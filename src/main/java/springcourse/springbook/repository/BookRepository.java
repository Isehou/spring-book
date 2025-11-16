package springcourse.springbook.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import springcourse.springbook.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BookRepository {
    private final Map<Integer, Book> books = new HashMap<>();

    public Book save(Book book) {
        books.put(book.getId(), book);
        log.info("Book saved" + book.getTitle());
        return book;
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Book findById(int id) {
        return books.get(id);
    }

    public Book update(int id, Book book) {
        if(books.containsKey(id)) {
            books.put(id, book);
            log.info("Updated book with id {}", id);
            return book;
        } else {
            log.warn("Books with id {} not found", id);
            return null;
        }
    }

    public boolean delete(int id) {
        if(books.containsKey(id)) {
            books.remove(id);
            log.info("Delete this book {}", id);
            return true;
        } else {
            log.warn("Book with id {} not found", id);
            return false;
        }
    }
}
