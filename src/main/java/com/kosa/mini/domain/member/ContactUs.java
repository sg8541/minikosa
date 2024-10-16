package com.kosa.mini.domain.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactUs {
    private Long contactId;
    private Long memberId;
    private String title;
    private String storeName;
    private String content;
    private LocalDateTime createdAt ; // 데이터베이스에 저장되는 비밀번호
    private LocalDateTime updatedAt;
    private boolean isModified;

}
