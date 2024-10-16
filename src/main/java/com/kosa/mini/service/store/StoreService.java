package com.kosa.mini.service.store;

import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.StoreDTO;

import java.util.List;

public interface StoreService {
    void createStore(StoreDTO storeDTO, List<MenuDTO> menuDTOs) throws Exception;
}
