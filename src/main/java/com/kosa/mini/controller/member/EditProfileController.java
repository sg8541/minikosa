package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.Member;
import com.kosa.mini.domain.member.EditProfileDTO;
import com.kosa.mini.domain.member.UserSessionDTO;
import com.kosa.mini.domain.store.Store;
import com.kosa.mini.service.member.EditProfileService;
import com.kosa.mini.service.store.StoreService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EditProfileController {

    @Autowired
    private EditProfileService editProfileService;

    @Autowired
    private StoreService storeService;
    
    // GET 요청 처리: 내 정보 수정 페이지 표시
    @GetMapping("/editprofile")
    public String editProfile(Model model, HttpSession session) {
        // 로그인한 사용자 정보 가져오기
        UserSessionDTO userSession = (UserSessionDTO) session.getAttribute("loggedInUser");
        if (userSession == null) {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // 회원 정보 조회
        EditProfileDTO editProfileDTO = editProfileService.getMemberById(userSession.getMemberId());

        // editMemberDTO 생성 및 데이터 설정

        // 사장님인 경우 가게명 조회
        if (editProfileDTO.getRoleId() == 3) {
            Store store = storeService.getStoreByOwnerId(editProfileDTO.getMemberId());
            if (store != null) {
                editProfileDTO.setStoreName(store.getStoreName());
            }
        }

        model.addAttribute("editProfileDTO", editProfileDTO);

        return "edit_profile"; // Thymeleaf 템플릿 파일명
    }

    // 닉네임 중복 검사 엔드포인트
    @GetMapping("/edit/check-nickname")
    @ResponseBody
    public ResponseEntity<?> checkNickname(@RequestParam("nickname") String nickname) {
        boolean exists = editProfileService.isNicknameExists(nickname);
        return ResponseEntity.ok().body("{\"exists\": " + exists + "}");
    }

    // POST 요청 처리: 회원 정보 업데이트
    @PostMapping("/editprofile")
    public String updateProfile(@ModelAttribute("editMemberDTO") EditProfileDTO editProfileDTO,
                                HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        // 로그인한 사용자 정보 가져오기
        UserSessionDTO userSession = (UserSessionDTO) session.getAttribute("loggedInUser");
        if (userSession == null) {
            // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // 비밀번호 확인
        if (editProfileDTO.getPassword() != null && !editProfileDTO.getPassword().isEmpty()) {
            if (!editProfileDTO.getPassword().equals(editProfileDTO.getConfirmPassword())) {
                model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
                return "edit_profile";
            }
        }

        // 업데이트할 회원 정보 설정
        Member updatedMember = new Member();
        updatedMember.setMemberId(userSession.getMemberId());
        updatedMember.setName(editProfileDTO.getName());
        updatedMember.setNickname(editProfileDTO.getNickname());
        updatedMember.setPhoneNumber(editProfileDTO.getPhoneNumber());

        if (editProfileDTO.getPassword() != null && !editProfileDTO.getPassword().isEmpty()) {
            // 비밀번호 암호화
            updatedMember.setPassword(editProfileDTO.getPassword());
        }

        // 회원 정보 업데이트
        editProfileService.updateMember(updatedMember);

        // 세션 정보 업데이트
        userSession.setName(updatedMember.getName());
        userSession.setNickname(updatedMember.getNickname());
        session.setAttribute("loggedInUser", userSession);

        // 업데이트 완료 후 메시지와 함께 editprofile 페이지로 이동
        redirectAttributes.addFlashAttribute("successMessage", "회원 정보가 성공적으로 수정되었습니다.");
        return "redirect:/editprofile";
    }
}
