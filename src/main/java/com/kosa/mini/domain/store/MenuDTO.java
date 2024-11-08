package com.kosa.mini.domain.store;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MenuDTO {
        private Long menuId;
        private Long storeId;
        private String menuName;
        private int price;
        private MultipartFile storePhoto;
}
