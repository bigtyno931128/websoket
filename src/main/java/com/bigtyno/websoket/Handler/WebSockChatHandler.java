//package com.bigtyno.websoket.Handler;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//// import 생략....
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class WebSockChatHandler extends TextWebSocketHandler {
//    private final ObjectMapper objectMapper;
//    private final ChatService chatService;
//
//
//    // 클라이언트에서 send를 이용해서 메시지 발송을 한 경우 이벤트 핸들링
//    // 메세지를 전송 받았을때 호출되는 메소드
//    //Client에서 send를 이용해서 요청을 하는 경우 handleTextMessage 함수에서 이벤트 핸들링
//    // WebSocketSession session : 전송 주체 정보가 담긴 세션
//    // TextMessage message : 전송 받은 메세지 정보
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//
//        System.out.println(message.getPayload());
//        String payload = message.getPayload();
//        log.info("payload {}", payload);
//// 삭제        TextMessage textMessage = new TextMessage("Welcome chatting sever~^^ ");
//// 삭제       session.sendMessage(textMessage);
//        //objectMapper.readValue() == JSON → Java Object
//        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
//        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
//        room.handleActions(session, chatMessage, chatService);
//    }
//}