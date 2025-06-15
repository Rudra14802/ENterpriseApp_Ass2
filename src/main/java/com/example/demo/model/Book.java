package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title;

//    @ManyToOne
//    @JoinColumn(name = "publisher_id")
//    private Publisher publisher;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "publisher_id")
//    private Publisher publisher;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties({"books"})
    private Publisher publisher;
    public Book() {}

    public Book(Long id, String name, String title, Publisher publisher) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
