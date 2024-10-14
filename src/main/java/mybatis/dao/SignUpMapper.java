package mybatis.dao;

import com.kosa.mini.domain.member.SignupDTO;
import org.apache.ibatis.annotations.*;



@Mapper
public interface SignUpMapper {


@Insert("insert into members (name, email, nickname, password,phone_number) " +
        "values (#{name}, #{email}, #{nickname}, #{password}, #{phone_number})")
    public boolean insert(SignupDTO dto);
}
