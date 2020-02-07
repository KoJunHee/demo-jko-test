package me.jko.demojkotests;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private LocalDate publishedDate;

    private boolean published;

    public void publish() {
        this.published = true;
        this.publishedDate = LocalDate.now();
    }
}
