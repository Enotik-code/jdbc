package by.jrr.service;

import by.jrr.bean.Book;
import by.jrr.dao.service.BookDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDaoService bookDaoService;

    public void addBook(String name, String author, String country, int countOfPages){
        bookDaoService.addBokToDb(Book.builder()
                .author(author)
                .name(name)
                .country(country)
                .countOfPages(countOfPages)
                .build());
    }

    public List<Book> findAllBooks(){
        return bookDaoService.findAllBooks();
    }

}
