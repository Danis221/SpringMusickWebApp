package ru.itis.mv.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.mv.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Page<Article> findAllByGenre(Pageable pageable, String genre);
    Page<Article> findAll(Pageable pageable);
}
