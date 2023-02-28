package be.intecbrussel.library;

import be.intecbrussel.library.entity.Author;
import be.intecbrussel.library.entity.Book;
import be.intecbrussel.library.entity.Category;
import be.intecbrussel.library.entity.Publisher;
import be.intecbrussel.library.service.BookServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Bean   //this method is going to be executed when you launch the application for the first time.
    public CommandLineRunner initialCreate(BookServiceImp bookServiceImp) {
        return (args) -> {
            Book book1 = new Book("ABC", "Book name1", "My first book");
            Author author1 = new Author("Test name1", "Test description");
            Category category1 = new Category("Business books");
            Publisher publisher1 = new Publisher("First Publisher");
            book1.addAuthor(author1);
            book1.addCatigory(category1);
            book1.addPublisher(publisher1);
            bookServiceImp.createbook(book1);

            Book book2 = new Book("ABC1", "Book name2", "My first book");
            Author author2 = new Author("Test name2", "Test description");
            Category category2 = new Category("Science books");
            Publisher publisher2 = new Publisher("Second Publisher");
            book2.addAuthor(author2);
            book2.addCatigory(category2);
            book2.addPublisher(publisher2);
            bookServiceImp.createbook(book2);

            Book book3 = new Book("ABC21", "Book name3", "My first book");
            Author author3 = new Author("Test name3", "Test description");
            Category category3 = new Category("Fiction books");
            Publisher publisher3 = new Publisher("Third Publisher");
            book3.addAuthor(author3);
            book3.addCatigory(category3);
            book3.addPublisher(publisher3);
            bookServiceImp.createbook(book3);
        };

    }
}

