package com.kosa.mini.service.member;

import com.kosa.mini.domain.member.ContactUs;
import com.kosa.mini.domain.member.SuggestionDTO;

import java.util.List;

public interface SuggestionService {
    void createSuggestion(SuggestionDTO suggestionDTO);
    ContactUs getSuggestionById(Long contactId);
    void incrementViews(Long contactId);

    // 페이지네이션
    List<ContactUs> getSuggestionsWithPagination(int offset, int limit);
    int getTotalSuggestionCount();
    void deleteSuggestion(Long contactId);
}
