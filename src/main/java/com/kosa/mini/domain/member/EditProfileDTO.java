package com.kosa.mini.domain.member;


import lombok.Data;

@Data
public class EditProfileDTO {
    private String name;       // 사용자 이름
    private String nickname;    // 닉네임
    private String email;        // 이메일
    private String phoneNumber;  // 전화번호
    private String password;     // 비밀번호
}
