
package com.myproject.service;

import com.myproject.entity.Book;
import com.myproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private RestTemplate restTemplate;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findBooksByGenre(genre);
    }
    
    public void addBook() {
        String url = "http://localhost:8080/books";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String newBookJson = "{ \"title\": \"Cantik Itu Luka\", \"author\": \"Eka Kurniawan\", \"genre\": \"Classic\", \"year\": 2002 }";
        HttpEntity<String> request = new HttpEntity<>(newBookJson, headers);

        String response = restTemplate.exchange(url, HttpMethod.POST, request, String.class).getBody();
        System.out.println("Response: " + response);
    }
}
