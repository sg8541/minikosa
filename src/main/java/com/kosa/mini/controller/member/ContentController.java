package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.StoreContentDTO;
import com.kosa.mini.service.member.StoreContentService;
import mybatis.dao.StoreContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store/")
public class ContentController {

    @Autowired
    private StoreContentService service;

    @GetMapping("/{num}")
    public String storeInfo(@PathVariable int num,
                            Model model){
        StoreContentDTO store = service.storeInfo(num);
        model.addAttribute("content", store);

        return "content";
    }


}
