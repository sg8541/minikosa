package mybatis.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.kosa.mini.domain.store.*;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface StoreContentMapper {

    // 가게 정보
    @Select("select   " +
            "    s.store_id,   " +
            "    s.store_name,   " +
            "    s.postcode,   " +
            "    s.road_address,   " +
            "    s.detail_address,   " +
            "    s.extra_address,   " +
            "    s.store_description,   " +
            "    s.opening_time,   " +
            "    s.closing_time,   " +
            "    s.website_info,  " +
//            "    s.contact_number " +
            "    s.contact_number, " +
            "    round(avg(r.rating),1) as 'ratingAvg',  " +
            "    count(r.review_id) as 'countReview' " +
            "FROM   " +
            "    stores s   " +
            "Left JOIN   " +
            "    reviews r  " +
            "ON s.store_id = r.store_id   " +
            "WHERE   " +
            "    s.store_id = #{num}")
    public StoreContentDTO storeInfo(int num);

    // 가게 메뉴
    @Select("SELECT " +
            "   menu_name, " +
            "   price " +
            "FROM " +
            "   menus " +
            "WHERE " +
            "   store_id = #{num}")
    public List<MenuDTO> getStoreMenuAll(int num);


    // 가게 리뷰 + 답글
    @Select("select " +
            "r.store_id, r.member_id, r.review_text, r.rating, r.created_at, r.review_id, " +
            "rr.reply_id, rr.review_id, rr.owner_id, rr.reply_text " +
            "from  " +
            "reviews r  " +
            "left join review_replies rr " +
            "on r.review_id = rr.reply_id " +
            "left join roles roles " +
            "on roles.role_id = rr.owner_id " +
            "where r.store_id = #{num}")
    public List<ReviewReplyDTO> getStoreReplyAll(int num);

    @Insert("insert into reviews " +
            "   (store_id, member_id, review_text, rating) " +
            "values " +
            "   (#{storeId},  #{memberId}, #{reviewText}, #{rating})")
    public boolean insertUserReview(int storeId, int memberId, String reviewText, int rating);


    @Update("update " +
            "   reviews " +
            "set " +
            "   review_text = #{reviewText}, rating = #{rating} " +
            "where " +
            "   review_id = #{reviewId} and member_id = #{memberId}")
    public boolean updateUserReview(StoreReviewDTO reviewDTO);

    @Delete("delete from reviews " +
            "where member_id = #{num}")
    public boolean deleteUserReview(int num);

    @Select("Select select store_id " +
            "from reviews " +
            "where member_id = #{num}")
    public int getUserReview(int num);

    @Delete("delete from stores " +
            "where store_id = #{num}")
    public boolean deleteStore(int num);
}
