package mybatis.dao;

import com.kosa.mini.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("SELECT * FROM members WHERE email = #{email}")
    Member findByEmail(String email);
}
