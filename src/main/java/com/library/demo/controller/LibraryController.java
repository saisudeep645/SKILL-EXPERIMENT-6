package com.library.demo.controller;

import com.library.demo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    // 2. Welcome Message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Library!";
    }

    // 3. Total Books Count
    @GetMapping("/count")
    public int getCount() {
        return bookList.size();
    }

    // 4. Sample Book Price
    @GetMapping("/price")
    public double getPrice() {
        return 499.99;
    }

    // 5. List of Book Titles
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        for (Book b : bookList) {
            titles.add(b.getTitle());
        }
        return titles;
    }

    // 6. Get Book by ID
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        if (id >= 0 && id < bookList.size()) {
            return bookList.get(id);
        }
        return null;
    }

    // 7. Search by Title
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book: " + title;
    }

    // 8. Author Name
    @GetMapping("/author/{name}")
    public String getAuthor(@PathVariable String name) {
        return "Books written by: " + name;
    }

    // 9. Add Book
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 10. View All Books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}