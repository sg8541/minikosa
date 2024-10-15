package com.kosa.mini.controller.store;

import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.StoreContentDTO;
import com.kosa.mini.service.store.StoreContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store/")
public class StoreContentController {

    @Autowired
    private StoreContentService service;

    @GetMapping("/{num}")
    public String getStoreInfo(@PathVariable int num,
                            Model model){
        StoreContentDTO store = service.storeInfo(num);
        List<MenuDTO> menu = service.getStoreMenuAll(num);
        model.addAttribute("content", store);
        model.addAttribute("menu", menu);

        return "content";
    }
}
