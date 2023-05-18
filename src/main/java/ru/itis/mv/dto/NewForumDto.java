package ru.itis.mv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.mv.model.Article;
import ru.itis.mv.model.Forum;
import ru.itis.mv.model.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewForumDto {
    @NotEmpty(message = "the forum header must not be empty")
    @Size(min = 5, max = 100, message
            = "Forum Header must be between 10 and 100 characters")
    private String forumHeader;

    public static NewForumDto fromEntity(Forum forum) {
        return NewForumDto.builder()
                .forumHeader(forum.getForumHeader())
                .build();
    }
}
