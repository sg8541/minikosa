package com.kosa.mini.controller.admin;

import com.kosa.mini.domain.member.UserSessionDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("register/owner")
    public String registerOwnerView(Model model, HttpSession session) {
        Object loggedInUserObj = session.getAttribute("loggedInUser");

        if (loggedInUserObj == null) {
            return "redirect:/home";
        }

        // 세션 객체를 UserSessionDTO로 캐스팅
        if (!(loggedInUserObj instanceof UserSessionDTO)) {
            // 세션 객체가 UserSessionDTO가 아니면 홈으로
            return "redirect:/home";
        }

        UserSessionDTO loggedInUser = (UserSessionDTO) loggedInUserObj;

        // roleId가 3인지 확인
        if (loggedInUser.getRoleId() != 2) {
            // roleId가 3이 아니면 접근 불가, 접근 거부 페이지나 홈으로 리다이렉트
            return "redirect:/home"; // 접근 거부 페이지를 따로 만들거나 홈으로 리다이렉트
        }

        // roleId가 3이면 admin/register 페이지로 이동
        return "admin_register_owner";
    }

    @GetMapping("create/store")
    public String createStoreView(Model model, HttpSession session) {
        Object loggedInUserObj = session.getAttribute("loggedInUser");

        if (loggedInUserObj == null) {
            return "redirect:/home";
        }

        // 세션 객체를 UserSessionDTO로 캐스팅
        if (!(loggedInUserObj instanceof UserSessionDTO)) {
            // 세션 객체가 UserSessionDTO가 아니면 홈으로
            return "redirect:/home";
        }

        UserSessionDTO loggedInUser = (UserSessionDTO) loggedInUserObj;

        // roleId가 3인지 확인
        if (loggedInUser.getRoleId() != 2) {
            // roleId가 3이 아니면 접근 불가, 접근 거부 페이지나 홈으로 리다이렉트
            return "redirect:/home"; // 접근 거부 페이지를 따로 만들거나 홈으로 리다이렉트
        }

        // roleId가 3이면 admin/register 페이지로 이동
        return "admin_create_store";
    }

}
