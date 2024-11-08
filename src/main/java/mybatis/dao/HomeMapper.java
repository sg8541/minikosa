package mybatis.dao;

import com.kosa.mini.domain.home.StoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeMapper {

    @Select("select " +
            "   s.store_id, " +
            "   s.store_name, " +
            "   s.store_photo, " +
            "   s.store_description, " +
            "   round(avg(r.rating),1) as ratingAvg, " +
            "   c.category_name " +
            "from " +
            "   stores s " +
            "left join " +
            "   reviews r " +
            "on " +
            "   s.store_id = r.store_id " +
            "left join " +
            "   categories c " +
            "on " +
            "   c.category_id = s.category_id " +
            "group by " +
            "   s.store_id")
    public List<StoreDTO> viewStoreAll();
}
