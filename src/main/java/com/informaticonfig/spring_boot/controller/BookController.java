package com.informaticonfig.spring_boot.controller;

import com.informaticonfig.spring_boot.entity.Book;
import com.informaticonfig.spring_boot.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BooksRepository booksRepository;

    @GetMapping
    public ResponseEntity<List<Book>> bookList() {
        return new ResponseEntity<>(booksRepository.findAll(), HttpStatus.OK);
    }


}
