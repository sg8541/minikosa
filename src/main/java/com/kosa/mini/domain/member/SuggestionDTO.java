package com.kosa.mini.domain.member;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SuggestionDTO {
    private Long memberId;

    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    private String title;

    @NotBlank(message = "가게이름은 필수 입력 항목입니다.")
    private String storeName;

    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    private String content;

}
