package be.intecbrussel.library.repository;

import be.intecbrussel.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM BOOKS_CATEGORY b WHERE b.category_Id = :categoryId", nativeQuery = true)
    void deleteByCategoryId(@Param("categoryId") Long categoryId);
}
