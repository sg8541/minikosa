package com.kosa.mini.domain.member;

import lombok.Data;

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

   private String menuName;
   private int price;

}
