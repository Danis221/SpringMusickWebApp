package ru.itis.mv.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private  String videoFromYoutube;

    @Column(nullable = false)
    private  String content;

    @Column(nullable = false)
    private  String genre;

    @Column(nullable = false)
    private LocalDate created;
}
