package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.StoreContentDTO;
import org.springframework.stereotype.Service;

@Service
public interface StoreContentService {

    public StoreContentDTO storeInfo(int num);
}
