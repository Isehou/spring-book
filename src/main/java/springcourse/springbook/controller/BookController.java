package springcourse.springbook.controller;

import org.springframework.web.bind.annotation.*;
import springcourse.springbook.model.BookModel;
import springcourse.springbook.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public String addBook(@RequestBody BookModel book) {
        return bookService.save(book);
    }

    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id) {
        BookModel book = bookService.findById(id);
        if(book == null) {
            return "Книга не найдена";
        }
        return "Книга: " + book.getAuthor() + " " + book.getTitle();
    }

}
