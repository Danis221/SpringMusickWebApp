package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Article;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleDto {

    @Size
    private String authorEmail;

    private String content;

    private LocalDate created;

    private String name;

    private String videoFromYoutube;

    private String genre;
    public static ArticleDto fromEntity(Article article) {
        return ArticleDto.builder()
                .authorEmail(article.getAuthor().getEmail())
                .created(article.getCreated())
                .content(article.getContent())
                .name(article.getName())
                .videoFromYoutube(article.getVideoFromYoutube())
                .genre(article.getGenre())
                .build();
    }

    public static ArticleDto fromEntity(NewOrUpdateArticleDto article) {
        return ArticleDto.builder()
                .content(article.getContent())
                .name(article.getName())
                .videoFromYoutube(article.getVideoFromYoutube())
                .genre(article.getGenre())
                .build();
    }
    public static List<ArticleDto> fromEntity(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }
}
