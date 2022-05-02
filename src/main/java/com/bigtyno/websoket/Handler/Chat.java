package com.bigtyno.websoket.Handler;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tbl_chat")
public class Chat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chat_id")
    private Long id;

    //private ChatMessage.MessageType type; // 메시지 타입
    private String roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지


    public Chat(String message1, String nickname, String planId) {
        this.roomId = planId;
        this.sender = nickname;
        this.message = message1;
    }
}
