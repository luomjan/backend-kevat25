package kevat25.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kevat25.bookstore.model.BookRepository;

//Add a new controller called BookController which handle get request to the path /index

@Controller
public class BookstoreController {

    @Autowired
    private BookRepository repository;

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
