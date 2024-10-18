package com.kosa.mini.service.store;

import com.kosa.mini.domain.member.Member;
import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.Store;
import com.kosa.mini.domain.store.StoreDTO;

import java.util.List;

public interface StoreService {
    void createStore(StoreDTO storeDTO, List<MenuDTO> menuDTOs) throws Exception;

    void assignOwnerAndUpdateRole(Long storeId, Long ownerId);

    List<Member> searchMembersByEmail(String email);

    List<StoreDTO> searchStoresByName(String storeName);

    Store getStoreByOwnerId(Long owerId);
}
