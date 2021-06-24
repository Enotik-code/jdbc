package by.jrr.dao.service;

import by.jrr.bean.Book;
import by.jrr.dao.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDaoService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.selectAllFromBook();
    }

    public Book findBookById(Long id){
        return bookRepository.selectAllFromBook().stream()
                .filter(book -> book.getId().longValue() == id)
                .findAny()
                .orElse(null);
    }

    public void addBokToDb(Book book){
        bookRepository.save(book);
    }
}
