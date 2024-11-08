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
    public SearchResultDTO search(String query, String sort, String type) {
        SearchResultDTO result = new SearchResultDTO();
        result.setQuery(query);

        // Initialize default sorts
        String storeSort = "s.updated_at DESC";
        String reviewSort = "rv.updated_at DESC";

        if ("rating".equals(sort)) {
            if ("store".equals(type)) {
                storeSort = "ratingAvg DESC";
            } else if ("review".equals(type)) {
                reviewSort = "rv.rating DESC";
            }
        }

        // Fetch and set store results
        List<StoreDTO> stores = searchMapper.searchStores(query, storeSort);
        result.setStoreResults(stores);
        result.setStoreCount(searchMapper.countStoreResults(query));

        // Fetch and set review results
        List<StoreReviewDTO> reviews = searchMapper.searchReviews(query, reviewSort);
        result.setReviewResults(reviews);
        result.setReviewCount(searchMapper.countReviewResults(query));

        return result;
    }
}
