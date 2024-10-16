package mybatis.dao;

import com.kosa.mini.domain.store.Menu;
import com.kosa.mini.domain.store.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreMapper {

    @Insert("INSERT INTO stores (store_name, postcode, road_address, detail_address, extra_address, category_id, store_photo, store_description, owner_id, opening_time, closing_time, website_info, contact_number, created_at, updated_at, is_modified) " +
            "VALUES (#{storeName}, #{postcode}, #{roadAddress}, #{detailAddress}, #{extraAddress}, #{categoryId}, #{storePhoto}, #{storeDescription}, #{ownerId}, #{openingTime}, #{closingTime}, #{websiteInfo}, #{contactNumber}, #{createdAt}, #{updatedAt}, #{isModified})")
    @Options(useGeneratedKeys = true, keyProperty = "storeId")
    void insertStore(Store store);

    @Insert({
            "<script>",
            "INSERT INTO menus (store_id, menu_name, price, menu_photo) VALUES ",
            "<foreach collection='menus' item='menu' separator=','>",
            "(#{storeId}, #{menu.menuName}, #{menu.price}, #{menu.menuPhoto})",
            "</foreach>",
            "</script>"
    })
    void insertMenus(@Param("storeId") Long storeId, @Param("menus") List<Menu> menus);
}

