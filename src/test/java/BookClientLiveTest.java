import by.jrr.jdbc.template.models.BookClient;
import by.jrr.jdbc.template.models.BookResourse;
import by.jrr.jdbc.template.models.BookControllerFeignClientBuilder;
import by.jrr.jdbc.template.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertTrue;

@Slf4j
public class BookClientLiveTest {
    private BookClient bookClient;

    @Before
    public void setup() {
        BookControllerFeignClientBuilder feignClientBuilder = new BookControllerFeignClientBuilder();
        bookClient = feignClientBuilder.getBookClient();
    }

    @Test
    public void givenBookClient_shouldRunSuccessfully() throws Exception {
        List<Book> books = bookClient.findAll()
                .stream()
                .map(BookResourse::getBook)
                .collect(Collectors.toList());
        assertTrue(books.size() > 2);
        log.info("{}", books);
    }

    @Test
    public void givenBookClient_shouldFindOneBook() throws Exception {
        Book book = bookClient.findByIsbn("0151072558")
                .getBook();
        assertThat(book.getAuthor(), containsString("Orwell"));
        log.info("{}", book);
    }

    @Test
    public void givenBookClient_shouldPostBook() throws Exception {
        String isbn = UUID.randomUUID()
                .toString();
        Book book = new Book(isbn, "Me", "It's me!", null, null);
        bookClient.create(book);

        book = bookClient.findByIsbn(isbn)
                .getBook();
        assertThat(book.getAuthor(), is("Me"));
        log.info("{}", book);
    }
}

