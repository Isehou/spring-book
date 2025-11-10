package springcourse.springbook.service;

import org.springframework.stereotype.Service;
import springcourse.springbook.model.BookModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final Map<String, BookModel> books = new HashMap<>();

    public List<BookModel> findAll() {
        return new ArrayList<>(books.values());
    }

    public String save(BookModel book) {
        if(books.containsKey(book.getId())) {
            return "Такая книга уже существует";
        }

        if(book.getTitle() == null || book.getTitle().isBlank()) {
            return "Название книги обязательно";
        }
        if(book.getAuthor() == null || book.getAuthor().isBlank()) {
            return "Автор обязателен";
        }

        books.put(book.getTitle(), book);
        return "Книга успешно добавлена";
    }

    public BookModel findById(int id) {
        return books.get(id);
    }
}

