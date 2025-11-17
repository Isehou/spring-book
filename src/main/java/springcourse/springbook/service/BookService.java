package springcourse.springbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springcourse.springbook.model.Book;
import springcourse.springbook.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository repository;

    public Book addBook(Book book) {
        if(book.getTitle() == null || book.getTitle().isEmpty()) {
            log.error("Данная книга пуста");
            return null;
        }
        if(book.getAuthor() == null || book.getAuthor().isEmpty()) {
            log.error("В книге нету автора");
            return null;
        }
        if(book.getYear() <= 0) {
            log.error("Год книги не может быть отрицательным");
            return null;
        }

        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(int id) {
        return repository.findById(id);
    }

    public Book updateBook(int id, Book book) {
        return repository.update(id, book);
    }

    public void deleteBook(int id) {
        Book book = repository.findById(id);
        if(book == null) {
            log.warn("Книга с таким id {} не найдена" + id);
            return;
        }
        book.setAvailable(false);
        repository.update(id, book);

        log.info("Книга с таким id {} отключена", id);
    }
}
