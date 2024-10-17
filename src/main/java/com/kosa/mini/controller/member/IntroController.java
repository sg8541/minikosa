package com.kosa.mini.controller.member;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
    @GetMapping("/intro")
    public String introView(Model model) {
        return "intro";
    }
}
