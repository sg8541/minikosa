package mybatis.dao;

import com.kosa.mini.domain.home.StoreDTO;
import com.kosa.mini.domain.store.StoreReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {

    // 가게 검색 - 동적 정렬 적용
    @Select("SELECT " +
            "s.store_id, " +
            "s.store_name, " +
            "s.store_photo, " +
            "s.store_description, " +
            "ROUND(AVG(r.rating), 1) AS ratingAvg, " +
            "c.category_name " +
            "FROM stores s " +
            "LEFT JOIN reviews r ON s.store_id = r.store_id " +
            "LEFT JOIN categories c ON s.category_id = c.category_id " +
            "WHERE s.store_name LIKE CONCAT('%', #{query}, '%') " +
            "OR s.store_description LIKE CONCAT('%', #{query}, '%') " +
            "GROUP BY s.store_id " +
            "ORDER BY ${sort}")
    List<StoreDTO> searchStores(@Param("query") String query, @Param("sort") String sort);

    // 리뷰 검색 - 동적 정렬 적용
    @Select("SELECT " +
            "rv.review_id, " +
            "rv.store_id, " +
            "s.store_name, " +
            "rv.member_id, " +
            "m.nickname AS memberNickname, " +
            "rv.review_text, " +
            "rv.rating, " +
            "rv.created_at AS createdAt, " +
            "rv.updated_at AS updatedAt, " +
            "rv.is_modified " +
            "FROM reviews rv " +
            "JOIN members m ON rv.member_id = m.member_id " +
            "JOIN stores s ON rv.store_id = s.store_id " +
            "WHERE rv.review_text LIKE CONCAT('%', #{query}, '%') " +
            "OR m.nickname LIKE CONCAT('%', #{query}, '%') " +
            "ORDER BY ${sort}")
    List<StoreReviewDTO> searchReviews(@Param("query") String query, @Param("sort") String sort);

    // 가게 검색 결과 개수
    @Select("SELECT COUNT(*) FROM stores WHERE store_name LIKE CONCAT('%', #{query}, '%') OR store_description LIKE CONCAT('%', #{query}, '%')")
    int countStoreResults(@Param("query") String query);

    // 리뷰 검색 결과 개수
    @Select("SELECT COUNT(*) FROM reviews rv JOIN members m ON rv.member_id = m.member_id WHERE rv.review_text LIKE CONCAT('%', #{query}, '%') OR m.nickname LIKE CONCAT('%', #{query}, '%')")
    int countReviewResults(@Param("query") String query);
}
