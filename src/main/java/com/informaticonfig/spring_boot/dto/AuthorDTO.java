package com.informaticonfig.spring_boot.dto;

import com.informaticonfig.spring_boot.entity.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {

    private Integer id;
    private String name, lastName;

    public AuthorDTO(Author p_author) {
        this.id = p_author.getId();
        this.name = p_author.getName();
        this.lastName = p_author.getLastName();
        /*this.phone = p_author.getPhone();*/
    }
}
