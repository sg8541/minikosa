package com.kosa.mini.controller.home;

import com.kosa.mini.domain.home.StoreDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeSearchController {
    @GetMapping("/search")
    public String goHome(Model model, String query) {
        return "search_view";
    }
}
