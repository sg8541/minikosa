package com.kosa.mini.controller.admin;

import com.kosa.mini.domain.member.UserSessionDTO;
import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.StoreDTO;
import com.kosa.mini.service.store.StoreService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final StoreService storeService;

    @Autowired
    public AdminController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("register/owner")
    public String registerOwnerView() {
        return "admin_register_owner";
    }

    @GetMapping("create/store")
    public String createStoreView(Model model, HttpSession session) {
        // 현재 로그인된 사용자 정보 가져오기
        UserSessionDTO loggedInUser = (UserSessionDTO) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !loggedInUser.getRoleId().equals(2)) { // roleId 2가 ADMIN
            return "redirect:/access-denied";
        }

        model.addAttribute("storeDTO", new StoreDTO());
        return "admin_create_store";
    }

    @PostMapping("create/store")
    public String createStore(@Valid StoreDTO storeDTO,
                              BindingResult bindingResult,
                              Model model,
                              HttpSession session) {
        UserSessionDTO loggedInUser = (UserSessionDTO) session.getAttribute("loggedInUser");
        if (loggedInUser == null || !loggedInUser.getRoleId().equals(2)) {
            return "redirect:/access-denied";
        }

        if (bindingResult.hasErrors()) {
            return "admin_create_store";
        }

        try {
            storeService.createStore(storeDTO, storeDTO.getMenuDTOs());
            model.addAttribute("successMessage", "가게와 메뉴가 성공적으로 등록되었습니다.");
            return "redirect:/content";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "admin_create_store";
        }
    }
}
