package com.kosa.mini.domain.store;

import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Store {
    private Long storeId;
    private String storeName;
    private String postcode;
    private String roadAddress;
    private String detailAddress;
    private String extraAddress;
    private Integer categoryId;
    private String storePhoto;
    private String storeDescription;
    private Long ownerId;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String websiteInfo;
    private String contactNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isModified;
}
