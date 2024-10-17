package com.kosa.mini.controller.member;


import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.exception.DuplicateEmailException;
import com.kosa.mini.exception.DuplicateNicknameException;
import com.kosa.mini.exception.SignupException;
import com.kosa.mini.service.member.EditProfileService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditProfileController {
    private EditProfileService editProfileService;        //서비스를 상수로 고정시켜서 변형못하게 x

    @Autowired
    public EditProfileController(EditProfileService editProfileService) {
        this.editProfileService = editProfileService;
    }

    @GetMapping("/editprofile")
    public String editprofileSession(Model model, HttpSession session) {         //get으로 받는게 세션상태에서 받는걸 의미? 물어봐야겠다

        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "editprofile";
        }
        model.addAttribute("editprofileDTO", new EditProfileDTO());
        return "editprofile";
    }


}
