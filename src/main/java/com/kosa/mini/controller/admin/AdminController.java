package com.kosa.mini.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("register/owner")
    public String registerOwnerView() {
        return "admin_register_owner";
    }

    @GetMapping("create/store")
    public String createStoreView() {
        return "admin_create_store";
    }
}
