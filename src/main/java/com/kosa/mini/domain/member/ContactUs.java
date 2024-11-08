package com.kosa.mini.domain.member;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContactUs {
    private Long contactId;
    private Long memberId;
    private String memberName; // 작성자 이름
    private String title;
    private String storeName;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isModified;
    private int views; // 조회수 필드 추가
}
