package ru.itis.mv.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.mv.controller.api.ArticleApi;
import ru.itis.mv.dto.ArticleDto;
import ru.itis.mv.dto.ArticlePage;
import ru.itis.mv.dto.NewOrUpdateArticleDto;
import ru.itis.mv.service.ArticleService;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api")
@RestController
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @Override
    public ResponseEntity<ArticlePage> getAllArticles(int page, Optional<String> genre) {
        if(genre.isPresent()) {
            return ResponseEntity
                    .ok(articleService.getArticlesByGenreAndPage(page, genre.get()));
        } else {
            return ResponseEntity
                    .ok(articleService.getAllArticles(page));
        }
    }
    @Override
    public ResponseEntity<ArticleDto> getArticle(int id) {
        return ResponseEntity
                .ok(articleService.getArticleById(id));
    }

    @Override
    public ResponseEntity<ArticleDto> createArticle(NewOrUpdateArticleDto newArticleDro) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(articleService.createArticle(newArticleDro));
    }

    @Override
    public ResponseEntity<ArticleDto> updateLesson(Integer articleId, NewOrUpdateArticleDto updateArticle) {
        return ResponseEntity.accepted()
                .body(articleService.updateArticle(articleId, updateArticle));
    }
}
