package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.FindEmailDTO;
import com.kosa.mini.service.member.FindEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FindEmailController {
    private final FindEmailService findEmailService;

    @Autowired
    public FindEmailController(FindEmailService findEmailService){
        this.findEmailService = findEmailService;
    }

    @GetMapping("/findemail")
    public String showFindEmailForm(Model model){
        model.addAttribute("findEmailDTO", new FindEmailDTO());
        return "findemail";
    }
    @PostMapping("/findemail")
    public String findEmail(@Valid FindEmailDTO findEmailDTO,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            return "findemail";
        }

        try {
            String email = findEmailService.findEmail(findEmailDTO);
            model.addAttribute("foundEmail", email);
            return "findemail";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "findemail";
        }
    }

}
