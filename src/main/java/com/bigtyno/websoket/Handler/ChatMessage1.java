package com.bigtyno.websoket.Handler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessage1 {
    private String sender; // 메시지 보낸사람
    private String message; // 메시지

    public ChatMessage1(String sender, String message) {
        this.sender =sender;
        this.message = message;
    }
}
