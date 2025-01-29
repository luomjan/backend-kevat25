package kevat25.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kevat25.bookstore.model.BookRepository;

@Controller
public class BookstoreController {

    private BookRepository repository;

    public BookstoreController(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/index")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/booklist")
    public String showBookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

}
