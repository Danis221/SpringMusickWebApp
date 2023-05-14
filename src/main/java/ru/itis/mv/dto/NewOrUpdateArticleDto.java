package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Article;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewOrUpdateArticleDto {
    private String name;

    private String videoFromYoutube;

    private String content;

    private String genre;
    public static NewOrUpdateArticleDto fromEntity(Article article) {
        return NewOrUpdateArticleDto.builder()
                .name(article.getName())
                .videoFromYoutube(article.getVideoFromYoutube())
                .genre(article.getGenre())
                .content(article.getContent())
                .build();
    }

    public static List<NewOrUpdateArticleDto> fromEntity(List<Article> articles) {
        return articles.stream()
                .map(NewOrUpdateArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

}
