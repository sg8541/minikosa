package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.StoreContentDTO;
import mybatis.dao.StoreContentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreContentServiceImpl implements StoreContentService {

    @Autowired
    private StoreContentMapper dao;


    @Override
    public StoreContentDTO storeInfo(int num) {
        return dao.storeInfo(num);
    }
}
