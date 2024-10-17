package mybatis.dao;

import com.kosa.mini.domain.store.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface MenuMapper {

    @Insert("INSERT INTO menus (store_id, name, price, menu_photo_path) " +
            "VALUES (#{storeId}, #{name}, #{price}, #{menuPhotoPath})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertMenu(Menu menu);
}
