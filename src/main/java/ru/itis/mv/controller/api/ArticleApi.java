package ru.itis.mv.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.mv.dto.ArticleDto;
import ru.itis.mv.dto.ArticlePage;
import ru.itis.mv.dto.ExceptionDto;
import ru.itis.mv.dto.NewOrUpdateArticleDto;

import java.util.Optional;

@Tags(value = {
        @Tag(name = "Article")
})
public interface ArticleApi {

    @Operation(summary = "Getting a list of articles")
    @Parameters(value = {
            @Parameter(name = "page", required = true, description = ": The page number", example = "1"),
            @Parameter(name = "genre", description = ": The genre of the articles", example = "rok"),
    })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Articles page",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ArticlePage.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Error information",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionDto.class))
                    })
    })
    @GetMapping("/articles")
    ResponseEntity<ArticlePage> getAllArticles(@Parameter(description = "Page number") @RequestParam(value = "page", defaultValue = "0") int page,
                                               @Parameter(description = "genre", example = "rock") @RequestParam(value = "genre", required = false) Optional<String> genre);

    @Operation(summary = "Getting a article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article information",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ArticleDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Error information",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionDto.class))
                    })
    })
    @GetMapping("/article/{id}")
    ResponseEntity<ArticleDto> getArticle(@Parameter(description = "article id", example = "1") @PathVariable int id);

    @Operation(summary = "article creation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created article",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ArticleDto.class))
                    })
    })
    @PostMapping("/create/article")
    ResponseEntity<ArticleDto> createArticle(@RequestBody NewOrUpdateArticleDto newArticleDro);

    @Operation(summary = "Updating article")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated article",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ArticleDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Error information",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionDto.class))
                    }
            )

    })
    @PatchMapping("/update/article/{article-id}")
    ResponseEntity<ArticleDto> updateLesson(@Parameter(description = "article id", example = "1") @PathVariable("article-id") Integer articleId,
                                            @RequestBody NewOrUpdateArticleDto updateArticle);
}
