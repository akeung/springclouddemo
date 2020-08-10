/*
 * FileName: SendMessageController
 * Author:   Akeung
 * Date:     2020/8/10
 */
package com.ak.demo.controller;

import com.ak.demo.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akeung
 * 2020/8/10
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String send() {
        return messageProvider.send();
    }
}
