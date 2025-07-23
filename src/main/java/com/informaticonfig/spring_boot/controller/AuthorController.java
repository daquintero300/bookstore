package com.informaticonfig.spring_boot.controller;

import com.informaticonfig.spring_boot.entity.Author;
import com.informaticonfig.spring_boot.service.IAuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>>  authorList() {
        return new ResponseEntity<>(authorService.listAuthor(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> authorById(@PathVariable Integer id) {
        Optional<Author> author = authorService.findAuthorById(id);
        return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
        Optional<Author> authorExist = authorService.findAuthorById(id);
        if (authorExist.isPresent()) {
            Author updateAuthor = authorExist.get();
            updateAuthor.setName(author.getName());
            updateAuthor.setLastName(author.getLastName());
            updateAuthor.setPhone(author.getPhone());
            return new ResponseEntity<>(authorService.saveAuthor(updateAuthor), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id) {
        try {
            authorService.deleteAuthorById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
