package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.LoginDTO;
import com.kosa.mini.domain.member.UserSessionDTO;
import com.kosa.mini.exception.LoginException;
import com.kosa.mini.service.member.LoginService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String loginView(Model model, HttpSession session) {
        // 로그인 상태인지 확인
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser != null) {
            // 이미 로그인된 사용자는 홈 페이지로 리다이렉트
            return "redirect:/home";
        }
        model.addAttribute("loginDTO", new LoginDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginDTO") LoginDTO loginDTO,
                        BindingResult bindingResult,
                        Model model,
                        HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login"; // 입력값 검증 실패 시 로그인 페이지로 되돌아감
        }

        try {
            UserSessionDTO userSession = loginService.authenticate(loginDTO);

            // 세션에 UserSession 정보 저장
            session.setAttribute("loggedInUser", userSession);
            // 성공 후 /home으로 리다이렉트하면서 쿼리 파라미터 추가
            return "redirect:/home"; // 로그인 성공 시 홈 페이지로 이동
        } catch (LoginException e) {
            // 로그인 실패 시 세션 초기화
            session.invalidate(); // 전체 세션 무효화
            model.addAttribute("errorMessage", e.getMessage());
            return "login"; // 로그인 실패 시 로그인 페이지로 되돌아가면서 오류 메시지 표시
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 이동
    }
}
