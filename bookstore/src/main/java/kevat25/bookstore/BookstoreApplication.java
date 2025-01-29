package kevat25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.bookstore.model.Book;
import kevat25.bookstore.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Sormuksen ritarit", "J.R.R. Tolkien", "978-951-0-33337-2", 1954, 19.99));
			repository.save(new Book("Kaksi tornia", "J.R.R. Tolkien", "978-951-0-33337-3", 1954, 19.99));
			repository.save(new Book("Kuninkaan paluu", "J.R.R. Tolkien", "978-951-0-33337-4", 1955, 19.99));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
