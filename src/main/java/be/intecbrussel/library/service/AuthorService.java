package be.intecbrussel.library.service;

import be.intecbrussel.library.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AuthorService {
    public List<Author> findAllAuthor();

    public Author findAuthorById(Long id);

    public void createAuthor(Author author);

    public void deleteAuthor(Long id);

    public void updateAuthor(Author author);
}
