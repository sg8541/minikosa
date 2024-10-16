package com.kosa.mini.controller.store;

import com.kosa.mini.domain.store.*;
import com.kosa.mini.service.store.StoreContentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store/")
public class StoreContentController {

    @Autowired
    private StoreContentService service;

    // 가게 내용 + 댓글 정보 불러오기
    @GetMapping("/{num}")
    public String getStoreInfo(@PathVariable int num,
                               Model model){
        StoreContentDTO store = service.storeInfo(num);
        List<MenuDTO> menu = service.getStoreMenuAll(num);
        List<ReviewReplyDTO> review = service.getStoreReplyAll(num);
        model.addAttribute("content", store);
        model.addAttribute("menu", menu);
        model.addAttribute("review", review);
        return "content";
    }

    // 가게 정보 삭제
    @GetMapping("/{num}/close")
    public String closeStore(@PathVariable int num){

        boolean success = service.coloseStore(num);
        if(success){
            return "redirect:/home";
        }else{
            return "redirect:/store/{num}";
        }

    /*가게 유저 리뷰 작성 및 수정*/
    @PostMapping("/{num}/review")
    public String insertAndUpdateReviews(@PathVariable int num,
                                         Model model,
                                         int storeId,
                                         int memberId,
                                         String reviewText,
                                         int rating,
                                         int reviewId){
        final int NO_DATA = 0;

        if(reviewId == NO_DATA) {
            boolean success = service.insertUserReview(storeId,memberId,reviewText,rating);
            if (success) {
                return "redirect:/store/{num}";
            } else {
                return "redirect:/store/{num}";
            }
        }else{
            StoreReviewDTO reviewDTO = new StoreReviewDTO();
            reviewDTO.setReviewId(reviewId);
            reviewDTO.setReviewText(reviewText);
            reviewDTO.setRating(rating);
            reviewDTO.setMemberId(memberId);
            reviewDTO.setStoreId(storeId);
            boolean success = service.updateUserReview(reviewDTO);
            if (success) {
                return "redirect:/store/{num}";
            } else {
                return "redirect:/store/{num}";
            }
        }
    }
    // 유저 댓글 삭제
    @PostMapping("/{num}/review/{memberId}")
    public String deleteReviews(@PathVariable int num,
                                @PathVariable int memberId) {

        boolean success = service.deleteUserReview(memberId);
        if (success) {
            return "redirect:/store/{num}";
        } else {
            return "redirect:/store/{num}";
        }

    }


}
