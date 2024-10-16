package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.FindEmailDTO;
import com.kosa.mini.domain.member.Member;
import mybatis.dao.FindEmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindEmailServiceImpl implements FindEmailService{
    private final FindEmailMapper findEmailMapper;

    @Autowired
    public FindEmailServiceImpl(FindEmailMapper findEmailMapper) {
        this.findEmailMapper = findEmailMapper;
    }

    @Override
    public String findEmail(FindEmailDTO findEmailDTO) throws Exception{
        Member member = findEmailMapper.findMemberByNickNameAndPhoneNumber(findEmailDTO.getNickname(), findEmailDTO.getPhoneNumber());
        if(member != null){
            return member.getEmail();
        }else{
            throw new Exception("일치하는 사용자 정보가 없습니다.");
        }
    }
}
