package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Article;
import ru.itis.mv.model.Forum;
import ru.itis.mv.model.User;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewForumDto {
    private String forumHeader;



    public static NewForumDto fromEntity(Forum forum) {
        return NewForumDto.builder()
                .forumHeader(forum.getForumHeader())
                .build();
    }
}
