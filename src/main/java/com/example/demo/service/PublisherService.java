package com.example.demo.service;

import com.example.demo.model.Publisher;
import java.util.List;

public interface PublisherService {
    Publisher savePublisher(Publisher publisher);
    List<Publisher> getAllPublishers();
    Publisher getPublisherById(Long id);
    void deletePublisher(Long id);
}
