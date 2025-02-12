package kevat25.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import kevat25.bookstore.model.*;

@RestController
public class BookRestController {

    private static final Logger log = LoggerFactory.getLogger(BookRestController.class);

    private final BookRepository bRepository;
    private CategoryRepository cRepository;

    public BookRestController(BookRepository bRepository, CategoryRepository cRepository) {
        this.bRepository = bRepository;
        this.cRepository = cRepository;
    };

    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        log.info("fetch and return books");
        return bRepository.findAll();
    }

    @PostMapping("books")
    Book newBook(@RequestBody Book newBook) {
        log.info("save new book " + newBook);
        return bRepository.save(newBook);
    }

    @PutMapping("/books/{id}")
    Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
        log.info("edit book " + editedBook);
        editedBook.setId(id);
        return bRepository.save(editedBook);
    }

    @DeleteMapping("/books/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id) {
        log.info("delete book, id = " + id);
        bRepository.deleteById(id);
        return bRepository.findAll();
    }

    @GetMapping("/books/{id}")
    Optional<Book> getBook(@PathVariable Long id) {
        log.info("find book, id = " + id);
        return bRepository.findById(id);
    }

    @GetMapping("/books/category/{name}")
    List<Book> getBookByCategory(@PathVariable String name) {
        log.info("find books, category = " + name);
        return bRepository.findByCategoryName(name);
    }

}
