package com.kosa.mini.service.search;

import com.kosa.mini.domain.search.SearchResultDTO;

public interface SearchService {
    SearchResultDTO search(String query);
}
