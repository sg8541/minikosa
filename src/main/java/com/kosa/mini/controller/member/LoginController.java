package com.kosa.mini.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginView() {
        return "login"; // 로그인 페이지 뷰 이름
    }
}
