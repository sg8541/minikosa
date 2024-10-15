package com.kosa.mini.domain.member;

import lombok.Data;

@Data
public class UserSessionDTO {
    private String name;
    private String email;
    private String nickname;
    private Integer roleId;
}
