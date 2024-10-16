package com.kosa.mini.domain.store;

import lombok.Data;

import java.util.List;

@Data
public class StoreContentDTO {
   private int storeId;
   private String storeName;
   private String postCode;
   private String roadAddress;
   private String detailAddress;
   private String extraAddress;
   private String storeDescription;
   private String webSiteInfo;
   private String contactNumber;
   private int ownerId;
   private double ratingAvg;
   private int countReview;
//   private List<MenuDTO> menuDTO;

}
