package com.kosa.mini.service.store;

import com.kosa.mini.domain.store.*;

import java.util.List;

public interface StoreContentService {

    public StoreContentDTO storeInfo(int num);

    public List<MenuDTO> getStoreMenuAll(int num);

    public boolean insertUserReview(int storeId, int memberId, String reviewText, int rating);

    public List<ReviewReplyDTO> getStoreReplyAll(int num);

    public boolean updateUserReview(StoreReviewDTO review);

    public boolean deleteUserReview(int num, int reviweId);

    public int getUserReview(int memberId);

    public boolean coloseStore(int num);

    public boolean insertReply(ReplyDTO replyDTO);

    boolean updateReply(String text, int replyId);

    boolean deleteReply(int replyId);
}
