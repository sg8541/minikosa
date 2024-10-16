package com.kosa.mini.domain.home;

import lombok.Data;

@Data
public class StoreDTO {
    private int storeId;
    private String storeName;
    private String storePhoto;
    private String storeDescription;
    private double ratingAvg;
    private String categoryName;

}
