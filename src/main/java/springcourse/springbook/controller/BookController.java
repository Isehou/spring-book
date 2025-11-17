package springcourse.springbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springcourse.springbook.model.Book;
import springcourse.springbook.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService service;

    @PostMapping
    public Book add(@RequestBody Book book) {
        log.info("Добавление книги");
        return service.addBook(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        log.info("Обновление книги {}", id);
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        log.info("Отключение книги {}", id);
        service.deleteBook(id);
    }
}
