package com.kosa.mini.domain.store;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ReviewReplyDTO {
    private int storeId;
    private int memberId;
    private String reviewText;
    private int rating;
    private Date createdAt;
    private int replyId;
    private int reviewId;
    private int ownerId;
    private String replyText;
    private String nickname;
}
