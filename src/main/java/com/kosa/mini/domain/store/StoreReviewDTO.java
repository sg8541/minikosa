package com.kosa.mini.domain.store;

import lombok.Data;

@Data
public class StoreReviewDTO {
    private int storeId;
    private int memberId;
    private String reviewText;
    private int rating;
    private int reviewId;


}
