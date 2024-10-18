package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.ContactUs;
import com.kosa.mini.domain.member.SuggestionDTO;
import mybatis.dao.SuggestionMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuggestionServiceImpl implements SuggestionService {
    private final SuggestionMapper suggestionMapper;

    public SuggestionServiceImpl(SuggestionMapper suggestionMapper) {
        this.suggestionMapper = suggestionMapper;
    }

    @Override
    public void createSuggestion(SuggestionDTO suggestionDTO) {
        ContactUs contactUs = new ContactUs();
        contactUs.setMemberId(suggestionDTO.getMemberId());
        contactUs.setTitle(suggestionDTO.getTitle());
        contactUs.setStoreName(suggestionDTO.getStoreName());
        contactUs.setContent(suggestionDTO.getContent());
        contactUs.setCreatedAt(LocalDateTime.now());
        contactUs.setUpdatedAt(LocalDateTime.now());
        contactUs.setModified(false);
        contactUs.setViews(0); // 조회수 초기화

        suggestionMapper.insertContactUs(contactUs);
    }

    @Override
    public ContactUs getSuggestionById(Long contactId) {
//        suggestionMapper.incrementViews(contactId);
        return suggestionMapper.getContactUsById(contactId);
    }

    @Override
    public List<ContactUs> getSuggestionsWithPagination(int offset, int limit) {
        return suggestionMapper.getSuggestionsWithPagination(offset, limit);
    }

    @Override
    public void incrementViews(Long contactId) {
        suggestionMapper.incrementViews(contactId);
    }

    @Override
    public int getTotalSuggestionCount() {
        return suggestionMapper.getTotalSuggestionCount();
    }

    @Override
    public void deleteSuggestion(Long contactId) {
        suggestionMapper.deleteSuggestion(contactId);
    }
}
