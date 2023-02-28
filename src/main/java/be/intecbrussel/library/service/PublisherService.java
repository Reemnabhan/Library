package be.intecbrussel.library.service;

import be.intecbrussel.library.entity.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> findAllPublisher();

    Publisher findPublisherById(Long id);

    void createPublisher(Publisher publisher);

    void deletePublisher(Long id);

    void updatePuplisher(Publisher publisher);
}
