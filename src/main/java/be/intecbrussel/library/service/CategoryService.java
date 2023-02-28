package be.intecbrussel.library.service;

import be.intecbrussel.library.entity.Book;
import be.intecbrussel.library.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAllCategory();

    Category findCategoryById(Long id);

    void createCategory(Category category);

    void deleteCategory(Long id);

    void updateCategory(Category category);
}
