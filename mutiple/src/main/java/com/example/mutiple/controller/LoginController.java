package com.example.mutiple.controller;

import com.example.mutiple.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public Map<String, Object> geteidCheck (@RequestParam String userid) {
        String result = loginService.idCheck(userid);
        return Map.of("msg", result);
    }



}
