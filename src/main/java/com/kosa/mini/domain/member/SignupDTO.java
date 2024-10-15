package com.kosa.mini.domain.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupDTO {
   @NotBlank(message = "이름은 필수 입력 항목입니다.")
   private String name;

   @NotBlank(message = "이메일은 필수 입력 항목입니다.")
   @Email(message = "유효한 이메일 형식을 입력해 주세요.")
   private String email;

   @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
   private String nickname;

   @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
   @Size(min = 4, message = "비밀번호는 최소 4자 이상이어야 합니다.")
   private String password;

   @NotBlank(message = "연락처는 필수 입력 항목입니다.")
   @Pattern(regexp = "^[0-9()+\\- ]+$", message = "유효한 연락처를 입력해 주세요.")
   private String phone_number;
}
