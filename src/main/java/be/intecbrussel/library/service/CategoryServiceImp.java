package be.intecbrussel.library.service;
import be.intecbrussel.library.entity.Author;
import be.intecbrussel.library.entity.Book;
import be.intecbrussel.library.entity.Category;
import be.intecbrussel.library.repository.CategoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @PersistenceContext
    private EntityManager em;


  //  @Override
   // public List<Category> findAllCategory() {
     //return categoryRepository.findAll();
  //  }
  @Override
  public List<Category> findAllCategory() {
      List<Category> categories = categoryRepository.findAll();
      categories.sort(Comparator.comparingLong(Category::getId));
      return categories;
  }

    @Override
    public Category findCategoryById(Long id) {
       Category category= categoryRepository.findById(id).
                orElseThrow(()->new RuntimeException("category is not found "));
        return category;
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        Category category= categoryRepository.findById(id).
                orElseThrow(()->new RuntimeException("category is not found "));

        categoryRepository.deleteByCategoryId(category.getId());
        categoryRepository.deleteById(category.getId());

    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);

    }
}

