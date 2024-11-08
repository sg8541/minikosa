package com.kosa.mini.controller.home;

import com.kosa.mini.domain.home.StoreDTO;
import com.kosa.mini.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private HomeService service;

    @GetMapping({"/", "/home"})
    public String goHome(Model model){
        List<StoreDTO> list = service.viewStoreHome();
        model.addAttribute("store", list);

        return "home";
    }
}
