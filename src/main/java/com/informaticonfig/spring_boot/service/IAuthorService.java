package com.informaticonfig.spring_boot.service;

import com.informaticonfig.spring_boot.entity.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {

    public List<Author> listAuthor();

    public Optional<Author> findAuthorById(Integer id);

    public Author updateAuthor(Integer id, Author author);

    public Author saveAuthor(Author author);

    public void deleteAuthorById(Integer id);
}
