package me.jko.demojkotests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @DisplayName("책을 만드는 테스트")
    @Test
    void createBook() {
        Book book = Book.builder()
            .title("The java")
            .author("jko")
            .isbn("21342af21df1")
            .build();

        book.publish();

        assertAll(
            () -> assertEquals(LocalDate.now(), book.getPublishedDate()),
            () -> assertTrue(book.isPublished())
        );
    }
}
