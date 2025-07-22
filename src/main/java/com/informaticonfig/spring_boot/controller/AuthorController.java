package com.informaticonfig.spring_boot.controller;

import com.informaticonfig.spring_boot.entity.Author;
import com.informaticonfig.spring_boot.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>>  authorList() {
        return new ResponseEntity<>(authorService.listAuthor(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> authorById(@PathVariable Integer id) {
        return new ResponseEntity<>(authorService.findAuthorById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthorById(id);
        System.out.println("The Author was deleted successfully");
    }
}
