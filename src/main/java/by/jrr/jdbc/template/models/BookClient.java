package by.jrr.jdbc.template.models;

import by.jrr.jdbc.template.models.Book;
import by.jrr.jdbc.template.models.BookResourse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "default", url = "https:localhost:8081/")
public interface BookClient {
    @RequestLine("GET /{isbn}")
    BookResourse findByIsbn(@Param("isbn") String isbn);

    @RequestLine("GET")
    List<BookResourse> findAll();

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void create(Book book);
}
