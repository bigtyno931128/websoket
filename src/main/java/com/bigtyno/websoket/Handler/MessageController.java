package com.bigtyno.websoket.Handler;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final ChatRepository chatRepository;

    //@PostMapping("/message/{id}")
//    @GetMapping("/message/{id}")
//    public ChatMessage1 getMessage(@PathVariable Long id ){
//        Chat chat = chatRepository.findById(id).orElseThrow(
//                IllegalArgumentException::new
//        );
//        ChatMessage1 chatMessage = new ChatMessage1();
//        chatMessage.setMessage(chat.getMessage());
//        chatMessage.setSender(chat.getSender());
//        //위도경도도
//       return chatMessage;
//    }

    @GetMapping("/message")
    public messageList chatMessage1s(){
        List<Chat> chats = chatRepository.findAll();
        List<ChatMessage1> chatMessage1s = new ArrayList<>();
        for(Chat chat : chats){
            String sender = chat.getSender();
            String message = chat.getMessage();
            ChatMessage1 chatMessage1 = new ChatMessage1(sender,message);
            chatMessage1s.add(chatMessage1);
        }
        return new messageList(chatMessage1s);
    }
}
