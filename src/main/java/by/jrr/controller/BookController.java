package by.jrr.controller;

import by.jrr.api.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import by.jrr.service.BookService;

@Controller
public class BookController {

    @Autowired
    private DataService dataService;

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/books")
    public ModelAndView getBooks() {
        ModelAndView modelAndView = new ModelAndView("/books.html");
        modelAndView.addObject("booksList", bookService.findAllBooks());
        return modelAndView;
    }

   /* @GetMapping(value = "/book/{id}")
    public ModelAndView getOneBook(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/books.html");
        modelAndView.addObject("booksList", bookDaoService.findBookById(Long.valueOf(id)));
        return modelAndView;
    }*/

    @GetMapping(value = "/addbook")
    public ModelAndView addBook() {
        ModelAndView modelAndView = new ModelAndView("/addBook.html");
        modelAndView.addObject("countryList", dataService.getAllCountries());
        return modelAndView;
    }

    @PostMapping(value = "/addbook")
    public ModelAndView addBookPost(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "author", required = false) String cargo,
                                    @RequestParam(value = "status", required = false) String country,
                                    @RequestParam(value = "count", required = false) int city) {
        ModelAndView modelAndView = new ModelAndView("/addBook.html");
        bookService.addBook(name, cargo, country, city);
        System.out.println("all okey");
        return new ModelAndView("/books.html");
    }
}
