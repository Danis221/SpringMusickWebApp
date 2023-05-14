package ru.itis.mv.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.itis.mv.aspect.Loggable;
import ru.itis.mv.dto.ArticleDto;
import ru.itis.mv.dto.ArticlePage;
import ru.itis.mv.dto.NewOrUpdateArticleDto;
import ru.itis.mv.model.Article;
import ru.itis.mv.model.User;
import ru.itis.mv.repository.ArticleRepository;
import ru.itis.mv.service.ArticleService;
import ru.itis.mv.service.UserService;

import java.time.LocalDate;

import static ru.itis.mv.dto.ArticleDto.fromEntity;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    //    @Value("${default.page-size}")
    private final int defaultPageSize = 20;
    private final ArticleRepository articleRepository;
    private final UserService userService;

    @Loggable
    @Override
    //TODO: автора через секьюрати
    public ArticleDto createArticle(NewOrUpdateArticleDto newArticleDro) {
        Article article = Article.builder()
                .created(LocalDate.now())
                .genre(newArticleDro.getGenre())
                .name(newArticleDro.getName())
                .author(userService.getCurrentUser())
                .videoFromYoutube(newArticleDro.getVideoFromYoutube())
                .content(newArticleDro.getContent())
                .build();

        articleRepository.save(article);

        return fromEntity(article);
    }

    @Override
    public ArticleDto getArticleById(Integer articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("article" + articleId + " not found"));
        return fromEntity(article);
    }

    @Override
    public ArticlePage getAllArticles(int page) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Article> articlePage = articleRepository.findAll(pageRequest);

        return ArticlePage.builder()
                .articles(fromEntity(articlePage.getContent()))
                .totalPagesCount(articlePage.getTotalPages())
                .build();

    }

    @Override
    public ArticlePage getArticlesByGenreAndPage(int page, String genre) {
        PageRequest pageRequest = PageRequest.of(page, defaultPageSize);
        Page<Article> articlePage = articleRepository.findAllByGenre(pageRequest, genre);

        return ArticlePage.builder()
                .articles(fromEntity(articlePage.getContent()))
                .totalPagesCount(articlePage.getTotalPages())
                .build();
    }

    @Override
    public ArticleDto updateArticle(Integer articleId, NewOrUpdateArticleDto updateArticle) {
        Article articleForUpdate = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("article" + articleId + " not found"));

        articleForUpdate.setContent(updateArticle.getContent());
        articleForUpdate.setName(updateArticle.getName());
        articleForUpdate.setVideoFromYoutube(updateArticle.getVideoFromYoutube());
        articleForUpdate.setGenre(updateArticle.getGenre());

        articleRepository.save(articleForUpdate);

        return fromEntity(updateArticle);
    }
}

