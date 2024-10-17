package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.ContactUs;
import com.kosa.mini.domain.member.SuggestionDTO;
import com.kosa.mini.domain.member.UserSessionDTO;
import com.kosa.mini.service.member.SuggestionService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SuggestionController {

    private final SuggestionService suggestionService;

    @Autowired
    public SuggestionController(SuggestionService suggestionService){
        this.suggestionService = suggestionService;
    }

    @GetMapping("/suggestion")
    public String suggestionView(Model model, HttpSession session) {
        // 로그인 상태인지 확인
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            // 이미 로그인된 사용자는 홈 페이지로 리다이렉트
            return "redirect:/login";
        }
        model.addAttribute("suggestionDTO", new SuggestionDTO());
        return "suggestion";
    }

    @PostMapping("/suggestion")
    public String submitSuggestion(@Valid SuggestionDTO suggestionDTO,
                                   BindingResult bindingResult,
                                   Model model,
                                   HttpSession session) {
        Object loggedInUserObj = session.getAttribute("loggedInUser");

        if (bindingResult.hasErrors()){
            return "suggestion";
        }

        UserSessionDTO loggedInUser = (UserSessionDTO) loggedInUserObj;
        suggestionDTO.setMemberId(loggedInUser.getMemberId());

        suggestionService.createSuggestion(suggestionDTO);
        model.addAttribute("successMessage", "제안이 성공적으로 접수되었습니다.");
        return "home";
    }

}
