package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateEmailException;
import com.kosa.mini.exception.DuplicateNicknameException;
import com.kosa.mini.exception.SignupException;
import com.kosa.mini.service.member.SignUpService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignupController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signup")
    public String signupView(Model model){
        model.addAttribute("signupDTO", new SignupDTO());
        return "signup";
    }

    @PostMapping("/signup")
    public String sign(@Valid @ModelAttribute("signupDTO") SignupDTO dto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "signup"; // 입력값 검증 실패 시 회원가입 페이지로 되돌아감
        }

        try {
            boolean success = signUpService.signUp(dto);
            if(success) {
                return "redirect:/login"; // 성공 시 로그인 페이지로 리다이렉트
            } else {
                model.addAttribute("errorMessage", "회원가입에 실패했습니다.");
                return "signup";
            }
        } catch (DuplicateEmailException | DuplicateNicknameException | SignupException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "signup"; // 예외 발생 시 회원가입 페이지로 되돌아가면서 오류 메시지 표시
        }
    }

    // 이메일 중복 검사 엔드포인트
    @GetMapping("/signup/check-email")
    @ResponseBody
    public ResponseEntity<?> checkEmail(@RequestParam("email") String email) {
        boolean exists = signUpService.isEmailExists(email);
        return ResponseEntity.ok().body("{\"exists\": " + exists + "}");
    }

    // 닉네임 중복 검사 엔드포인트
    @GetMapping("/signup/check-nickname")
    @ResponseBody
    public ResponseEntity<?> checkNickname(@RequestParam("nickname") String nickname) {
        boolean exists = signUpService.isNicknameExists(nickname);
        return ResponseEntity.ok().body("{\"exists\": " + exists + "}");
    }
}
