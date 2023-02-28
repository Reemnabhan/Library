package be.intecbrussel.library.service;

import be.intecbrussel.library.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {

    public List<Book> findAllBook();

    public Book findBookById(Long id);

    public void createbook(Book book);

    public void deleteBook(Long id);

    public void updateBook(Book book);

    public List<Book> searchBooks(String keyword);


}
