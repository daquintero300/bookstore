package com.informaticonfig.spring_boot.dto;

import com.informaticonfig.spring_boot.entity.Author;
import com.informaticonfig.spring_boot.entity.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class BookDTO {

    private Integer id;
    private String title, publisher, genre;
    private BigDecimal price;
    private LocalDate date;
    private AuthorDTO authorDTO;

    public BookDTO(Book p_book) {
        this.id = p_book.getId();
        this.title = p_book.getTitle();
        this.publisher = p_book.getPublisher();
        this.genre = p_book.getGenre();
        this.price = p_book.getPrice();
        this.date = p_book.getDate();
        this.authorDTO = new AuthorDTO(p_book.getAuthor());
    }
}
