package mybatis.dao;

import com.kosa.mini.domain.member.ContactUs;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SuggestionMapper {

    @Insert("INSERT INTO contact_us (member_id, title, store_name, content, created_at, updated_at, is_modified, views) " +
            "VALUES (#{memberId}, #{title}, #{storeName}, #{content}, NOW(), NOW(), 0, #{views})")
    @Options(useGeneratedKeys = true, keyProperty = "contactId")
    void insertContactUs(ContactUs contactUs);

    @Select("SELECT cu.contact_id, cu.title, cu.created_at, m.name, cu.views, cu.content " +
            "FROM contact_us cu " +
            "LEFT JOIN `members` m ON cu.member_id = m.member_id " +
            "ORDER BY cu.created_at DESC " +
            "LIMIT #{limit} OFFSET #{offset}")
    @Results({
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "memberName", column = "name"),
            @Result(property = "views", column = "views"),
            @Result(property = "content", column = "content")
    })
    List<ContactUs> getSuggestionsWithPagination(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT cu.title, cu.created_at, m.name, cu.views, cu.content " +
            "FROM contact_us cu " +
            "LEFT JOIN `members` m ON cu.member_id = m.member_id " +
            "WHERE cu.contact_id = #{contactId}")
    @Results({
            @Result(property = "title", column = "title"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "memberName", column = "name"),
            @Result(property = "views", column = "views"),
            @Result(property = "content", column = "content")
    })
    ContactUs getContactUsById(@Param("contactId") Long contactId);

    @Update("UPDATE contact_us SET views = views + 1 WHERE contact_id = #{contactId}")
    void incrementViews(@Param("contactId") Long contactId);

    @Select("SELECT COUNT(*) FROM contact_us")
    int getTotalSuggestionCount();

    @Delete("DELETE FROM contact_us WHERE contact_id = #{contactId}")
    void deleteSuggestion(@Param("contactId") Long contactId);
}
