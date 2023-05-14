package ru.itis.mv.service;

import ru.itis.mv.dto.ArticleDto;
import ru.itis.mv.dto.ArticlePage;
import ru.itis.mv.dto.NewOrUpdateArticleDto;

public interface ArticleService {
    ArticleDto createArticle(NewOrUpdateArticleDto newArticleDro);

    ArticleDto getArticleById(Integer id);

    ArticlePage getAllArticles(int page);

    ArticlePage getArticlesByGenreAndPage(int page, String genre);

    ArticleDto updateArticle(Integer articleId, NewOrUpdateArticleDto updateArticle);
}
