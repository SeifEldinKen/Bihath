package com.eldinstudio.bihath.data.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private String bookId, authorId, name;

    private List<Quote> quotesList;

    private List<Category> categoriesList;

}