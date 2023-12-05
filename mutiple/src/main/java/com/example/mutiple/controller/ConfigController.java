package com.example.mutiple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigController {

    @GetMapping("/config/configList")
    public String getConfigList() {
        return "config/configList";
    }

    @GetMapping("/config/configWrite")
    public String getConfigWrite() {
        return "config/configWrite";
    }
}
