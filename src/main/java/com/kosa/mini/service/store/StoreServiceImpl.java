package com.kosa.mini.service.store;

import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.Menu;
import com.kosa.mini.domain.store.Store;
import com.kosa.mini.domain.store.StoreDTO;
import mybatis.dao.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreMapper storeMapper;

    @Value("${file.store-photo-dir}")
    private String storePhotoDir;

    @Value("${file.menu-photo-dir}")
    private String menuPhotoDir;

    @Autowired
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public void createStore(StoreDTO storeDTO, List<MenuDTO> menuDTOs) throws Exception {
        Store store = new Store();
        store.setStoreName(storeDTO.getStoreName());
        store.setPostcode(storeDTO.getPostcode());
        store.setRoadAddress(storeDTO.getRoadAddress());
        store.setDetailAddress(storeDTO.getDetailAddress());
        store.setExtraAddress(storeDTO.getExtraAddress());
        store.setCategoryId(storeDTO.getCategoryId());
        store.setStoreDescription(storeDTO.getStoreDescription());
        store.setOwnerId(storeDTO.getOwnerId());

        if (storeDTO.getOpeningTime() != null && !storeDTO.getOpeningTime().isEmpty()) {
            store.setOpeningTime(LocalTime.parse(storeDTO.getOpeningTime()));
        }
        if (storeDTO.getClosingTime() != null && !storeDTO.getClosingTime().isEmpty()) {
            store.setClosingTime(LocalTime.parse(storeDTO.getClosingTime()));
        }

        store.setWebsiteInfo(storeDTO.getWebsiteInfo());
        store.setContactNumber(storeDTO.getContactNumber());

        // 가게 사진 저장 처리
        MultipartFile storePhoto = storeDTO.getStorePhoto();
        if (storePhoto != null && !storePhoto.isEmpty()) {
            String storePhotoPath = saveFile(storePhoto, storePhotoDir);
            store.setStorePhoto("/uploads/stores/" + storePhotoPath);
        }

        store.setCreatedAt(LocalDateTime.now());
        store.setUpdatedAt(LocalDateTime.now());
        store.setIsModified(false);

        // 가게 정보 저장
        storeMapper.insertStore(store);

        // 메뉴 정보 저장
        if (menuDTOs != null) {
            List<Menu> menus = new ArrayList<>();
            for (MenuDTO menuDTO : menuDTOs) {
                Menu menu = new Menu();
                menu.setStoreId(store.getStoreId());
                menu.setMenuName(menuDTO.getMenuName());
                menu.setPrice(menuDTO.getPrice());

                MultipartFile menuPhoto = menuDTO.getStorePhoto();
                if (menuPhoto != null && !menuPhoto.isEmpty()) {
                    String menuPhotoPath = saveFile(menuPhoto, menuPhotoDir);
                    menu.setMenuPhoto("/uploads/menus/" + menuPhotoPath);
                }

                menus.add(menu);
            }
            storeMapper.insertMenus(store.getStoreId(), menus);
        }
    }

    private String saveFile(MultipartFile file, String directory) throws IOException {
        File uploadDir = new File(directory);
        if (!uploadDir.exists() && !uploadDir.mkdirs()) {
            throw new IOException("업로드 디렉토리 생성에 실패했습니다.");
        }

        String originalFilename = file.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uniqueFilename = UUID.randomUUID().toString() + fileExtension;

        File dest = new File(uploadDir, uniqueFilename);
        file.transferTo(dest);

        return uniqueFilename;
    }
}