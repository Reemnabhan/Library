package be.intecbrussel.library.controller;

import be.intecbrussel.library.entity.Book;
import be.intecbrussel.library.service.AuthorServiceImp;
import be.intecbrussel.library.service.BookServiceImp;
import be.intecbrussel.library.service.CategoryServiceImp;
import be.intecbrussel.library.service.PublisherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookServiceImp bookServiceImp;

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Autowired
    private PublisherServiceImp publisherServiceImp;

    @Autowired
    private AuthorServiceImp authorServiceImp;


    @GetMapping("/books")
    public String findAllBooks(Model model) {
        List<Book> books = bookServiceImp.findAllBook();
        model.addAttribute("books", books);
        return "books";
    }


    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model) {
        Book book = bookServiceImp.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model) {
        bookServiceImp.deleteBook(id);
        model.addAttribute("books", bookServiceImp.findAllBook());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model) {
        Book book = bookServiceImp.findBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryServiceImp.findAllCategory());
        model.addAttribute("publishers", publisherServiceImp.findAllPublisher());
        model.addAttribute("authors", authorServiceImp.findAllAuthor());
        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-book";
        }
        bookServiceImp.updateBook(book);
        model.addAttribute("books", bookServiceImp.findAllBook());
        return "redirect:/books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book, Model model) {
        model.addAttribute("categories", categoryServiceImp.findAllCategory());
        model.addAttribute("publishers", publisherServiceImp.findAllPublisher());
        model.addAttribute("authors", authorServiceImp.findAllAuthor());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }
        bookServiceImp.createbook(book);
        model.addAttribute("books", bookServiceImp.findAllBook());
        return "redirect:/books";
    }

    @RequestMapping("/searchBook")
    public String searchBook(@Param("keyword") String keyword, Model model) {
        final List<Book> books = bookServiceImp.searchBooks(keyword);
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);
        return "books";
    }


}


