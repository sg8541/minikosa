package mybatis.dao;

import com.kosa.mini.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FindEmailMapper {
    @Select("SELECT * FROM members WHERE nickname= #{nickname} AND phone_number= #{phoneNumber}")
    Member findMemberByNickNameAndPhoneNumber(String nickname, String phoneNumber);
}
