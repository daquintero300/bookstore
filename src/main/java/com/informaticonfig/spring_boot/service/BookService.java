package com.informaticonfig.spring_boot.service;

import com.informaticonfig.spring_boot.entity.Book;
import com.informaticonfig.spring_boot.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Book> listBook() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        booksRepository.deleteById(id);
    }
}
