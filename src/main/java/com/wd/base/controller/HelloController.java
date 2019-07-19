package com.wd.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/helloHtml")
    public String HelloHtml(){
        int i = 0;
        System.out.println( "enterHtml" );
        return "test/index";
    }



}
