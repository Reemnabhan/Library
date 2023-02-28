package be.intecbrussel.library.controller;

import be.intecbrussel.library.entity.Book;
import be.intecbrussel.library.entity.Category;
import be.intecbrussel.library.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        List<Category> categories = categoryServiceImp.findAllCategory();
        model.addAttribute("categories", categories);
        return "categories";
    }


    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        categoryServiceImp.deleteCategory(id);
        model.addAttribute("categories", categoryServiceImp.findAllCategory());
        return "categories";
    }


    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        model.addAttribute("category", categoryServiceImp.findCategoryById(id));
        return "update-category";

    }

    @PostMapping("/update-category/{id}")
    public String saveCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update-category";
        }
        categoryServiceImp.updateCategory(category);
        model.addAttribute("categories", categoryServiceImp.findAllCategory());
        return "redirect:/categories";
    }


    @GetMapping("/add-category")
    public String addShoweCategory(Category category) {
       // model.addAttribute("categories", categoryServiceImp.findAllCategory());
        return "add-category";

    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-category";
        }
        categoryServiceImp.createCategory(category);
        model.addAttribute("categories", categoryServiceImp.findAllCategory());
        return "redirect:/categories";
    }


}
