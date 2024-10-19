package com.kosa.mini.controller.home;

import com.kosa.mini.domain.search.SearchResultDTO;
import com.kosa.mini.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String search(
            @RequestParam("q") String query,
            Model model
    ){
        SearchResultDTO searchResult = searchService.search(query);
        model.addAttribute("searchResult", searchResult);
        return "search_view";
    }
}
