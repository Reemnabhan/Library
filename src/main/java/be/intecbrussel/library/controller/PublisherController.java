package be.intecbrussel.library.controller;

import be.intecbrussel.library.entity.Author;
import be.intecbrussel.library.entity.Publisher;
import be.intecbrussel.library.service.PublisherServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private PublisherServiceImp publisherServiceImp;

    @GetMapping("/publishers")
    public String findAllPublishers(Model model) {
        model.addAttribute("publishers", publisherServiceImp.findAllPublisher());
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String deletepublisher(@PathVariable Long id, Model model) {
        publisherServiceImp.deletePublisher(id);
        model.addAttribute("publishers", publisherServiceImp.findAllPublisher());
        return "publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", publisherServiceImp.findPublisherById(id));
        return "/update-publisher";
    }


    @PostMapping("/update-publisher/{id}")
    public String saveUpdatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-publisher";
        }
        publisherServiceImp.updatePuplisher(publisher);
        model.addAttribute("publishers", publisherServiceImp.findAllPublisher());
        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher")
    public String addPublisherPage(Publisher publisher) {
        return "add-publisher";

    }

    @PostMapping("/save-publisher")
    public String createPublisher(Publisher publisher, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-publisher";
        }
        publisherServiceImp.createPublisher(publisher);
        model.addAttribute("publishers", publisherServiceImp.findAllPublisher());
        return "redirect:/publishers";
    }

}
