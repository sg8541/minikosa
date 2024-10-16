package com.kosa.mini.service.store;

import com.kosa.mini.domain.store.*;
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
    public boolean insertUserReview(int storeId, int memberId, String reviewText, int rating) {
        return dao.insertUserReview(storeId, memberId, reviewText, rating);
    }

    @Override
    public List<ReviewReplyDTO> getStoreReplyAll(int num) {
        return dao.getStoreReplyAll(num);
    }

    @Override
    public boolean updateUserReview(StoreReviewDTO review) {
        return dao.updateUserReview(review);
    }

    @Override
    public boolean deleteUserReview(int num) {
        return dao.deleteUserReview(num);
    }

    @Override
    public int getUserReview(int memberId) {
        int result = dao.getUserReview(memberId);
        return result;
    }

    @Override
    public boolean coloseStore(int num) {
        return dao.deleteStore(num);
    }

}
