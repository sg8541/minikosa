package com.kosa.mini.domain.member;

import lombok.Data;

@Data
public class UserInfoDTO {
    private int memberId;
    private String name;
    private String email;
    private String nickname;
    private Integer roleId;
}
