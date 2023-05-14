package ru.itis.mv.dto;

import lombok.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewPostDto {
    private String content;

    private Integer forumId;
}
