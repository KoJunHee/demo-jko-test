package me.jko.demojkotests;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final NotificationService notificationService;

    public Book createBook(Book book) {
        book.publish();
        Book newBook = bookRepository.save(book);
        notificationService.notify(newBook);

        return bookRepository.save(book);
    }
}
