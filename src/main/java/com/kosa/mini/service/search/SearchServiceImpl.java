package com.kosa.mini.service.search;

import com.kosa.mini.domain.search.SearchResultDTO;
import com.kosa.mini.domain.home.StoreDTO;
import com.kosa.mini.domain.store.StoreReviewDTO;
import mybatis.dao.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

    @Override
    public SearchResultDTO search(String query) {
        SearchResultDTO result = new SearchResultDTO();
        result.setQuery(query);

        List<StoreDTO> stores = searchMapper.searchStores(query);
        result.setStoreResults(stores);
        result.setStoreCount(searchMapper.countStoreResults(query));

        List<StoreReviewDTO> reviews = searchMapper.searchReviews(query);
        result.setReviewResults(reviews);
        result.setReviewCount(searchMapper.countReviewResults(query));

        return result;
    }
}
