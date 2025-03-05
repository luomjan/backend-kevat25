package kevat25.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kevat25.bookstore.model.Book;
import kevat25.bookstore.model.BookRepository;
import kevat25.bookstore.model.Category;
import kevat25.bookstore.model.CategoryRepository;


@SpringBootTest(classes = BookstoreApplication.class)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bRepository;

    @Autowired
    private CategoryRepository cRepository;

    @Test
    public void findByCategoryNameShouldReturnBook() {
        List<Book> books = bRepository.findByCategoryName("Fantasy");
        
        assertThat(books).isNotEmpty();
    
    }

    @Test
    public void createNewBook() {
        Category category = new Category("ufo");
        cRepository.save(category);
        Book book = new Book("Ufoja", "Hullu Matti", "00000", 2025, 10, category);
        bRepository.save(book);
        assertThat(book.getId()).isNotNull();

    }

    @Test
    public void deleteBookWorks() {
        Category category = new Category("ufo");
        cRepository.save(category);
        Book book = new Book("Ufoja", "Hullu Matti", "00000", 2025, 10, category);
        bRepository.save(book);
        bRepository.deleteById(book.getId());
        Optional<Book> deletedBook = bRepository.findById(book.getId());
        assertThat(deletedBook).isEmpty();
    }
    
}
