package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateResourceException;
import com.kosa.mini.exception.InvalidDataException;
import com.kosa.mini.service.member.SignUpService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping()
    public String signupView(){
        return "signup";
    }

    @PostMapping()
    public String sign(@ModelAttribute SignupDTO dto, HttpServletRequest req, Model model) {
        try {
            signUpService.signUp(dto);
            return "redirect:/login";
        } catch (DuplicateResourceException | InvalidDataException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "signup";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "회원가입 중 오류가 발생했습니다.");
            return "signup";
        }
    }
}
