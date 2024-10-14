package com.kosa.mini.controller.member;


import ch.qos.logback.core.model.Model;
import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.service.member.SignUpService;
import jakarta.servlet.http.HttpServletRequest;
import mybatis.dao.SignUpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private SignUpService signUpService;



    @GetMapping("/signup")
    public String signupView(){
        return "signup";
    }

    @PostMapping("/signup/insert")
    public String sign(SignupDTO dto, HttpServletRequest req) {
        boolean dtotwo = signUpService.signUp(dto);
        if (dto.getName() == null || dto.getName().equals("")) {
            dto.setName("홍길동");
        } else if (dto.getNickname() == null || dto.getNickname().equals("")) {
            dto.setNickname("동서남북");
        } else if (dto.getEmail() == null || dto.getEmail().equals("")) {
            dto.setEmail("없음");
        } else if (dto.getPhone_number() == null || dto.getPhone_number().equals("")) {
            dto.setPhone_number("없음");
        } else if (dto.getPassword() == null || dto.getPassword().equals("")) {
            dto.setPassword("없음");
        }
        return "redirect:/signup" ;

    }
}