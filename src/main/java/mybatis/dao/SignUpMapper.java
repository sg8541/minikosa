package mybatis.dao;

import com.kosa.mini.domain.member.SignupDTO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SignUpMapper {

    @Insert("INSERT INTO members (name, email, nickname, password, phone_number) " +
            "VALUES (#{name}, #{email}, #{nickname}, #{password}, #{phone_number})")
    int insert(SignupDTO dto);

    @Select("SELECT COUNT(*) FROM members WHERE nickname = #{nickname}")
    int countByNickname(String nickname);

    @Select("SELECT COUNT(*) FROM members WHERE email = #{email}")
    int countByEmail(String email);
}
