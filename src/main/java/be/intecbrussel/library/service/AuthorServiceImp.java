package be.intecbrussel.library.service;

import be.intecbrussel.library.entity.Author;
import be.intecbrussel.library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> findAllAuthor() {
        List<Author>authors=authorRepository.findAll();
        authors.sort(Comparator.comparingLong(Author::getId));
        return authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        Author author= authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author is not found"));
        return author;
    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);

    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Author is not found"));
        authorRepository.deleteById(author.getId());

    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.save(author);

    }
}
