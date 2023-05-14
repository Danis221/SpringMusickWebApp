package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Post;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    private String content;

    private Integer forumId;

    private String authorEmail;

    public static PostDto fromEntity(Post post) {
        return PostDto.builder()
                .forumId(post.getForum().getId())
                .content(post.getContent())
                .authorEmail(post.getAuthor().getEmail())
                .build();
    }

    public static List<PostDto> fromEntity(List<Post> posts) {
        return posts.stream()
                .map(PostDto::fromEntity)
                .collect(Collectors.toList());
    }
}
