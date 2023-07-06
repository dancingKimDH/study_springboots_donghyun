package com.example.study_springboots_donghyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    // Bracket을 통해 여러 URL로 들어올 수 있도록 함, 일종의 Array
    @GetMapping({"/", "/home", "/main"})
    public ModelAndView main(ModelAndView modelAndView) {
        
        return modelAndView;
    }
}
