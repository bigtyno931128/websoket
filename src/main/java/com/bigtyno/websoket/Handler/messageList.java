package com.bigtyno.websoket.Handler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class messageList {
    private List<ChatMessage1> chatMessage1s = new ArrayList<>();

    public messageList(List<ChatMessage1> chatMessage1s){
        this.chatMessage1s = chatMessage1s;
    }
}
