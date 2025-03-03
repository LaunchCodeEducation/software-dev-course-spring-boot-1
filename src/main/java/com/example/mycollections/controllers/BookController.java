package com.example.mycollections.controllers;

import com.example.mycollections.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>() {{
        add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 180));
        add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281));
        add(new Book("1984", "George Orwell", 1949, 328));
    }};

    @GetMapping("/json")
    public List<Book> getBooksJson() {
        return books;
    }

    @GetMapping("/html")
    public String getBooksHtml() {
        return """
                <html>
                    <body>
                        <h1>Books</h1>
                        <ul>
                            """
                + books.stream()
                        .map(book -> "<li>" + book + "</li>m") + 
                """
                        </ul>
                    </body>
                """;
    }

}