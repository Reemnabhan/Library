package be.intecbrussel.library.service;


import be.intecbrussel.library.entity.Publisher;
import be.intecbrussel.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PublisherServiceImp implements PublisherService{

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> findAllPublisher() {
        List<Publisher>publishers=publisherRepository.findAll();
        publishers.sort(Comparator.comparingLong(Publisher::getId));
        return publishers;

    }

    @Override
    public Publisher findPublisherById(Long id) {
        Publisher publisher= publisherRepository.findById(id).
                orElseThrow(()->new RuntimeException("Publisher is not found"));
        return publisher;

    }

    @Override
    public void createPublisher(Publisher publisher) {
        publisherRepository.save(publisher);

    }

    @Override
    public void deletePublisher(Long id) {
        Publisher publisher= publisherRepository.findById(id).
                orElseThrow(()->new RuntimeException("Publisher is not found"));
        publisherRepository.deleteById(publisher.getId());


    }

    @Override
    public void updatePuplisher(Publisher publisher) {
        publisherRepository.save(publisher);
    }


}
