package com.kosa.mini.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DuplicateEmailException.class)
  public String handleDuplicateEmailException(DuplicateEmailException ex, Model model) {
    model.addAttribute("errorMessage", ex.getMessage());
    return "signup"; // 회원가입 페이지로 이동하면서 오류 메시지 표시
  }

  @ExceptionHandler(DuplicateNicknameException.class)
  public String handleDuplicateNicknameException(DuplicateNicknameException ex, Model model) {
    model.addAttribute("errorMessage", ex.getMessage());
    return "signup";
  }

  @ExceptionHandler(SignupException.class)
  public String handleSignupException(SignupException ex, Model model) {
    model.addAttribute("errorMessage", ex.getMessage());
    return "signup";
  }

  // 일반적인 예외 처리
  @ExceptionHandler(Exception.class)
  public String handleException(Exception ex, Model model) {
    model.addAttribute("errorMessage", "알 수 없는 오류가 발생했습니다.");
    return "signup";
  }
}
