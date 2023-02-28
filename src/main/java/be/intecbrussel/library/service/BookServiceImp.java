package be.intecbrussel.library.service;

import be.intecbrussel.library.entity.Book;
import be.intecbrussel.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAllBook() {
        List<Book> books = bookRepository.findAll();
        books.sort(Comparator.comparingLong(Book::getId));
        return books;
    }


    @Override
    public Book findBookById(Long id) {
        Book book = bookRepository.
                findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return book;
    }

    @Override
    public void createbook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.deleteById(book.getId());
    }

    @Override
    public void updateBook(Book book) {

        bookRepository.save(book);
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        if (keyword != null) {
            return bookRepository.search(keyword);
        }
        return bookRepository.findAll();
    }

}




