package com.kosa.mini.domain.member;

import lombok.Data;

@Data
public class EditProfileDTO {
    private Long memberId;
    private String name;
    private String email;
    private String nickname;
    private String phoneNumber;
    private Integer roleId;
    private String storeName;

    private String password;
    private String confirmPassword;
}
