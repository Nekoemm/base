package com.wd.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping("/helloHtml")
    public String helloHtml() {
        int i = 0;
        return "test/index";
    }



}
