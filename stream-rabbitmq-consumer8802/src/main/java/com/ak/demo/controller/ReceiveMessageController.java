/*
 * FileName: ReceiveMessageController
 * Author:   Akeung
 * Date:     2020/8/10
 */
package com.ak.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author Akeung
 * 2020/8/10
 */
@EnableBinding(value = Sink.class)
@Component
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    @StreamListener(value = Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1，-------" + message.getPayload() + "\t port:" + serverPort);
    }

}
