package mybatis.dao;

import com.kosa.mini.domain.store.MenuDTO;
import com.kosa.mini.domain.store.StoreContentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StoreContentMapper {

    // 가게 정보
    @Select("SELECT " +
            "    store_id, " +
            "    store_name, " +
            "    postcode, " +
            "    road_address, " +
            "    detail_address, " +
            "    extra_address, " +
            "    store_description, " +
            "    contact_number, " +
            "    website_info " +
            "FROM " +
            "    stores " +
            "WHERE " +
            "    store_id = #{num}")
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
}
