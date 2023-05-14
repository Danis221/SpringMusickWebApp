package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Event;
import ru.itis.mv.model.Forum;
import ru.itis.mv.model.Post;
import ru.itis.mv.model.User;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ForumDto {
    private Integer id;

    private String forumHeader;

    private LocalDate created;

    private String authorEmail;

    private List<Integer> postsId;

    public static ForumDto fromEntity(Forum forum) {
        return ForumDto.builder()
                .id(forum.getId())
                .forumHeader(forum.getForumHeader())
                .created(forum.getCreated())
                .authorEmail(forum.getAuthor().getEmail())
                .build();
    }

    public static List<ForumDto> fromEntity(List<Forum> forums) {
        return forums.stream()
                .map(ForumDto::fromEntity)
                .collect(Collectors.toList());
    }
}
