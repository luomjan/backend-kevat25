package kevat25.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Add a new controller called BookController which handle get request to the path /index

@Controller
public class BookstoreController {

    @RequestMapping("/index")
    public String showIndexPage() {
        return "index";
    }

}
