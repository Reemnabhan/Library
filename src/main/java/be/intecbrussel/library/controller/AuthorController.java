package be.intecbrussel.library.controller;

import be.intecbrussel.library.entity.Author;
import be.intecbrussel.library.service.AuthorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {


    @Autowired
    private AuthorServiceImp authorServiceImp;

    @GetMapping("/authors")
    public String findAllAuthors(Model model) {
        model.addAttribute("authors", authorServiceImp.findAllAuthor());
        return "authors";
    }


    @GetMapping("/remove-author/{id}")
    public String deleteAuthor(@PathVariable Long id,Model model){
        authorServiceImp.deleteAuthor(id);
        model.addAttribute("authors", authorServiceImp.findAllAuthor());
        return "authors";
    }


    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id,Model model){
        model.addAttribute("author",authorServiceImp.findAuthorById(id));
        return "update-author";
    }

    @PostMapping("/update-author/{id}")
    public String SaveUpdateAuthor(@PathVariable Long id, Author author, BindingResult result,Model model){
        if (result.hasErrors()){
            return "update-author";
        }
        authorServiceImp.updateAuthor(author);
        model.addAttribute("authors",authorServiceImp.findAllAuthor());
        return "redirect:/authors";
    }

    @GetMapping("/add-author")
    public String showCreateAuthor(Author author){
        return "add-author";
    }

    @PostMapping("/save-author")
    public String addAuthor(Author author,BindingResult result,Model model){
        if (result.hasErrors()){
            return "add-author";
        }

        authorServiceImp.createAuthor(author);
        model.addAttribute("authors",authorServiceImp.findAllAuthor());
        return "redirect:/authors";
    }
}
