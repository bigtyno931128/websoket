package com.bigtyno.websoket.Handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 내장 브로커를 사용 하겠다 . /sub  으로 들어올경우
        config.enableSimpleBroker("/sub");
        //pub 으로 들어올 경우 handler 를 통하여 메세지를 가공 하겠다 .
        config.setApplicationDestinationPrefixes("/pub");
    }

    // stomp 를 사용하기 때문에 따로 핸들러를 만들어 줄 필요가 없다 .
    // cors 설정 가능 .
    // .withSockJs 는 soketJs 를 사용하게 해주는 방법.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp").setAllowedOrigins("*")
                .withSockJS();
    }
}
