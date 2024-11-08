package com.kosa.mini.service.home;

import com.kosa.mini.domain.home.StoreDTO;
import mybatis.dao.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public List<StoreDTO> viewStoreHome() {
        return homeMapper.viewStoreAll();
    }
}
