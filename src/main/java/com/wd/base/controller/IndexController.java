package com.wd.base.controller;

import com.wd.base.entity.TransDto;
import com.wd.base.entity.User;
import com.wd.base.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    UserService service;



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public TransDto toIndex(@RequestBody User data) {
        TransDto temp = new TransDto();
        if (service.LoginCheck(data)){
            temp.setStatus(TransDto.SUCCESS);
            temp.setMsg("login succeed");
            temp.setTransObject(data);
        }else {
            temp.setStatus(TransDto.ERROR);
            temp.setMsg("there are something wrong...please check youself");
            temp.setTransObject(data);
        }
        return temp;
    }
}
