package kevat25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kevat25.bookstore.model.AppUser;
import kevat25.bookstore.model.AppUserRepository;
import kevat25.bookstore.model.Book;
import kevat25.bookstore.model.BookRepository;
import kevat25.bookstore.model.Category;
import kevat25.bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository,
			AppUserRepository urepository) {
		return (args) -> {

			log.info("save categorys");
			categoryRepository.save(new Category("Fantasy"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Fiction"));

			log.info("save a couple of books");
			repository.save(new Book("Sormuksen ritarit", "J.R.R. Tolkien", "978-951-0-33337-2", 1954, 19.99,
					categoryRepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Kaksi tornia", "J.R.R. Tolkien", "978-951-0-33337-3", 1954, 19.99,
					categoryRepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Kuninkaan paluu", "J.R.R. Tolkien", "978-951-0-33337-4", 1955, 19.99,
					categoryRepository.findByName("Fantasy").get(0)));

			log.info("save user and admin");
			AppUser user1 = new AppUser("user", "$2a$10$0.CyWO.KVDv.I.LBt/LnMOMMMikflaK3o0z.gjnEaL1nJKwzV1ZUy", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$4/4hbxOU1OigHnAAhitiLu7EP43TgdjX.8Nzcyq.UmSsUDSGPFSEK",
					"ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
