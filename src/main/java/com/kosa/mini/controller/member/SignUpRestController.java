package com.kosa.mini.controller.member;

import com.kosa.mini.domain.member.SignupDTO;
import com.kosa.mini.exception.DuplicateResourceException;
import com.kosa.mini.exception.InvalidDataException;
import com.kosa.mini.service.member.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/signup")
public class SignUpRestController {

    @Autowired
    private SignUpService signUpService;

    @PostMapping("/check-nickname")
    public ResponseEntity<Boolean> checkNickname(@RequestParam String nickname) {
        boolean available = signUpService.isNicknameAvailable(nickname);
        return ResponseEntity.ok(available);
    }

    @PostMapping("/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean available = signUpService.isEmailAvailable(email);
        return ResponseEntity.ok(available);
    }

    @PostMapping
    public ResponseEntity<String> signUp(@Valid @RequestBody SignupDTO dto) {
        try {
            signUpService.signUp(dto);
            return ResponseEntity.ok("회원가입 성공");
        } catch (DuplicateResourceException | InvalidDataException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
        }
    }
}
