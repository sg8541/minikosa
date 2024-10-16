package com.kosa.mini.service.store;

import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.StoreContentDTO;
import mybatis.dao.StoreContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreContentServiceImpl implements StoreContentService {

    @Autowired
    private StoreContentMapper dao;


    @Override
    public StoreContentDTO storeInfo(int num) {
        return dao.storeInfo(num);
    }

    @Override
    public List<MenuDTO> getStoreMenuAll(int num) {
        return dao.getStoreMenuAll(num);
    }

    @Override
    public boolean coloseStore(int num) {
        return dao.deleteStore(num);
    }
}
