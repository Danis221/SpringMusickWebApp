package ru.itis.mv.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ChatMessage {
    private String content;
    private String sender;


}
