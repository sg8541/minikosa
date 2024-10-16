package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.ContactUs;
import com.kosa.mini.domain.member.SuggestionDTO;
import mybatis.dao.SuggestionMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SuggestionServiceImpl implements SuggestionService{
    private final SuggestionMapper suggestionMapper;


    public SuggestionServiceImpl(SuggestionMapper suggestionMapper) {
        this.suggestionMapper = suggestionMapper;
    }


    @Override
    public void createSuggestion(SuggestionDTO suggestionDTO) {
        ContactUs contactUs = new ContactUs();
        contactUs.setMemberId(suggestionDTO.getMember_id());
        contactUs.setTitle(suggestionDTO.getTitle());
        contactUs.setStoreName(suggestionDTO.getStoreName());
        contactUs.setContent(suggestionDTO.getContent());
        contactUs.setCreatedAt(LocalDateTime.now());
        contactUs.setUpdatedAt(LocalDateTime.now());
        contactUs.setModified(false);

        suggestionMapper.insertContactUs(contactUs);
    }
}
