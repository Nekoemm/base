package com.wd.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    @RequestMapping("chat")
    public String startChat(){
        int test = 0;
        return "test/event-index";
    }
}
