package me.jko.demojkotests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository = mock(BookRepository.class);
    @Mock
    NotificationService notificationService = mock(NotificationService.class);

    @Test
    void createBook() {
        // Given
        Book book = Book.builder()
            .title("The java")
            .author("jko")
            .isbn("21342af21df1")
            .build();
        Book bookResult = Book.builder()
            .title("The java")
            .author("jko")
            .isbn("21342af21df1")
            .build();
        bookResult.publish();
        given(bookRepository.save(book)).willReturn(bookResult);
        BookService bookService = new BookService(bookRepository, notificationService);

        // When
        Book bookToCheck = bookService.createBook(book);

        // Then
        assertTrue(bookToCheck.isPublished());
        then(notificationService).should().notify(bookResult);
    }
}
