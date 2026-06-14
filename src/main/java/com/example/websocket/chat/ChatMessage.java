package com.example.websocket.chat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {

    private String sender;
    private String content;
    private MessageType type;
}