package com.kosa.mini.service.store;

import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.StoreContentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StoreContentService {

    public StoreContentDTO storeInfo(int num);
    public List<MenuDTO> getStoreMenuAll(int num);

}
