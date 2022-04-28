package com.bigtyno.websoket.Handler;

// import 생략...

import com.bigtyno.websoket.Handler.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatRepository chatRepository;

    @Transactional
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.JOIN.equals(message.getType())){
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        String message1 = message.getMessage();
        String user = message.getSender();
        String planId = message.getRoomId();
        System.out.println("==============");
        System.out.println(message1);
        System.out.println(user);
        System.out.println(planId);
        Chat chat = new Chat(message1,user,planId);
        chatRepository.save(chat);


        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}