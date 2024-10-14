package mybatis.dao;

import com.kosa.mini.domain.member.StoreContentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreContentMapper {

    // 가게 정보
    @Select("SELECT " +
            "    store_id as 'storeId', " +
            "    store_name as 'storeName', " +
            "    postcode as 'postCode', " +
            "    road_address as 'roadAddress', " +
            "    detail_address as 'detailAddress', " +
            "    extra_address as 'extraAddress', " +
            "    store_description as 'storeDescription', " +
            "    contact_number as 'contactNumber', " +
//            "    opening_time, " +
//            "    closing_time, " +
            "    website_info as 'webSiteInfo'" +
            "FROM " +
            "    stores " +
            "WHERE " +
            "    store_id = #{num}")
    public StoreContentDTO storeInfo(int num);
}
