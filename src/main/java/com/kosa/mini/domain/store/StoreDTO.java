package com.kosa.mini.domain.store;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class StoreDTO {
    private Long storeId;
    private String storeName;
    private String postcode;
    private String roadAddress;
    private String detailAddress;
    private String extraAddress;
    private Integer categoryId;
    private MultipartFile storePhoto; // 가게 사진 업로드
    private String storeDescription;
    private Long ownerId;
    private String openingTime;
    private String closingTime;
    private String websiteInfo;
    private String contactNumber;

    // 메뉴 리스트
    private List<MenuDTO> menuDTOs;
}
