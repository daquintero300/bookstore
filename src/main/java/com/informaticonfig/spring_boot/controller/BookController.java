package com.informaticonfig.spring_boot.controller;

import com.informaticonfig.spring_boot.entity.Book;
import com.informaticonfig.spring_boot.service.IBookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> bookList() {
        return new ResponseEntity<>(bookService.listBook(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> bookById(@PathVariable Integer id) {
        Optional<Book> book = bookService.findBookById(id);
        return book.map( value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> bookExist = bookService.findBookById(id);
        if (bookExist.isPresent()) {
            Book updateBook = bookExist.get();
            updateBook.setAuthor(book.getAuthor());
            updateBook.setDate(book.getDate());
            updateBook.setGenre(book.getGenre());
            updateBook.setPrice(book.getPrice());
            updateBook.setPublisher(book.getPublisher());
            updateBook.setAuthor(book.getAuthor());
            return new ResponseEntity<>(bookService.saveBook(updateBook), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
