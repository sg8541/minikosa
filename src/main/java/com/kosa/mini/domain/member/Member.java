package com.kosa.mini.domain.member;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Member {
    private Long memberId;
    private String name;
    private String email;
    private String nickname;
    private String password; // 데이터베이스에 저장되는 비밀번호
    private Integer roleId;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
