package mybatis.dao;

import com.kosa.mini.domain.member.ContactUs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface SuggestionMapper {
    @Insert("INSERT INTO contact_us (member_id, title, store_name, content, created_at, updated_at, is_modified) " +
            "VALUES (#{memberId}, #{title}, #{storeName}, #{content}, NOW(), NOW(), 0)")
    @Options(useGeneratedKeys = true, keyProperty = "contactId")
    void insertContactUs(ContactUs contactUs);
}
