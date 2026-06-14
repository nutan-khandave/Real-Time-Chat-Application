package com.example.websocket.chat;

import com.example.websocket.entity.Message;
import com.example.websocket.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final MessageRepository repository;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage
    ) {

        // Save dynamic data in DB
        Message message = new Message();
        message.setSenderName(chatMessage.getSender());
        message.setMessage(chatMessage.getContent());

        repository.save(message);

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }
}