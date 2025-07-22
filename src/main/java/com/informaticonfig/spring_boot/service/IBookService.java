package com.informaticonfig.spring_boot.service;

import com.informaticonfig.spring_boot.entity.Author;
import com.informaticonfig.spring_boot.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    public List<Book> listBook();

    public Optional<Book> findBookById(Integer id);

    public Book saveBook(Book book);

    public void deleteBookById(Integer id);
}
