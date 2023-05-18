package ru.itis.mv.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewPostDto {
    @NotEmpty(message = "the content must not be empty")
    private String content;

    private Integer forumId;
}
