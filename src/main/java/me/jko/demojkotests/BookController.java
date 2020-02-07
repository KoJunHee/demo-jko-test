package me.jko.demojkotests;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    @PostMapping("books")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id){
        return bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
