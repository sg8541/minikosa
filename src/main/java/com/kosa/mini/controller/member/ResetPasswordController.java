package com.kosa.mini.controller.member;

import org.springframework.ui.Model;
import com.kosa.mini.domain.member.ResetPasswordDTO;
import com.kosa.mini.service.member.ResetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResetPasswordController {

    private final ResetPasswordService resetPasswordService;

    @Autowired
    public ResetPasswordController(ResetPasswordService resetPasswordService) {
        this.resetPasswordService = resetPasswordService;
    }

    // 비밀번호 초기화 폼을 보여줍니다.
    @GetMapping("/reset/password")
    public String resetPasswordForm(Model model) {
        model.addAttribute("passwordReset", false);
        return "reset_pw";
    }

    // 사용자의 정보를 조회하여 비밀번호 초기화 폼을 보여줍니다.
    @PostMapping("/search/member")
    public String searchMember(@ModelAttribute ResetPasswordDTO resetPasswordDTO, Model model) {
        ResetPasswordDTO member = resetPasswordService.searchMember(resetPasswordDTO.getName(), resetPasswordDTO.getPhoneNumber(), resetPasswordDTO.getEmail());
        if (member != null) {
            model.addAttribute("passwordReset", true);
            model.addAttribute("email", member.getEmail());
            return "reset_pw";
        } else {
            model.addAttribute("errorMessage", "입력하신 정보와 일치하는 회원을 찾을 수 없습니다.");
            model.addAttribute("passwordReset", false);
            return "reset_pw";
        }
    }

    // 비밀번호를 초기화합니다.
    @PostMapping("/reset/password")
    public String resetPassword(@ModelAttribute ResetPasswordDTO resetPasswordDTO, Model model) {
        try {
            boolean success = resetPasswordService.resetPassword(resetPasswordDTO);
            if (success) {
                model.addAttribute("successMessage", "비밀번호가 성공적으로 변경되었습니다.");
            } else {
                model.addAttribute("errorMessage", "비밀번호 변경에 실패했습니다.");
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
        }
        model.addAttribute("passwordReset", false);
        return "reset_pw";
    }
}
