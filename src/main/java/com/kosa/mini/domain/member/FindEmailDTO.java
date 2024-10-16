package com.kosa.mini.domain.member;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class FindEmailDTO {

    @NotBlank(message = "닉네임은 필수 입력 항목입니다.")
    private String nickname;

    @NotBlank(message = "연락처는 필수 입력 항목입니다.")
    @Pattern(regexp = "^[0-9\\-+() ]+$", message = "유효한 연락처를 입력해 주세요.")
    private String phoneNumber;
}
