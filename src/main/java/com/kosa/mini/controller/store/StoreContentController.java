package com.kosa.mini.controller.store;

import com.kosa.mini.domain.store.*;
import com.kosa.mini.service.store.StoreContentService;
import com.kosa.mini.service.store.StoreService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/store/")
public class StoreContentController {

    private StoreContentService service;
    private StoreService storeService;

    @Autowired
    public StoreContentController(StoreContentService service, StoreService storeService) {
        this.service = service;
        this.storeService = storeService;
    }


    // 가게 내용 + 댓글 정보 불러오기
    @GetMapping("/{num}")
    public String getStoreInfo(@PathVariable int num,
                               Model model,
                               HttpSession session) {
        // 로그인 상태인지 확인
        Object loggedInUser = session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        
        StoreContentDTO store = service.storeInfo(num);
        List<Menu> menu = service.getStoreMenuAll(num);
        List<ReviewReplyDTO> review = service.getStoreReplyAll(num);
        model.addAttribute("content", store);
        model.addAttribute("menu", menu);
        model.addAttribute("review", review);
        return "content";
    }

    /*가게 유저 리뷰 작성 및 수정*/
    @PostMapping("/{num}/review")
    public String insertAndUpdateReviews(@PathVariable int num,
                                         Model model,
                                         int storeId,
                                         int memberId,
                                         String reviewText,
                                         int rating,
                                         int reviewId) {
        final int NO_DATA = 0;

        if (reviewId == NO_DATA) {
            boolean success = service.insertUserReview(storeId, memberId, reviewText, rating);
            if (success) {
                return "redirect:/store/{num}";
            } else {
                return "redirect:/store/{num}";
            }
        } else {
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
                                @PathVariable int memberId,
                                int reviewId) {

        boolean success = service.deleteUserReview(memberId, reviewId);
        if (success) {
            System.out.println("리뷰 삭제~~~~~~~");
            return "redirect:/store/{num}";
        } else {
            return "redirect:/store/{num}";
        }

    }

    // 가게 정보 수정
    @GetMapping("/admin/edit")
    public String editeStore(long storeId,
                             StoreDTO storeDTO,
                             Model model) {
        storeDTO = storeService.storeInfo(storeId);
        System.out.println("가게 수정 페이지로 이동~~~~~~~~~~~~~~");
        model.addAttribute("storeDTO", storeDTO);
        return "admin_edit_store";
    }

    // 가게 정보 삭제
    @PostMapping("/{num}/close")
    public String closeStore(@PathVariable int num) {

        boolean success = service.coloseStore(num);
        if (success) {
            System.out.println("삭제 성공~~~~~~~~~~~~~");
            return "redirect:/home";
        } else {
            return "redirect:/store/{num}";
        }
    }

    // 사장의 답글
    @PostMapping("/{reviewId}/reply")
    public String replyToReview(@PathVariable int reviewId,
                                ReplyDTO replyDTO,
                                int storeId) {

        boolean success = service.insertReply(replyDTO);
        if (success) {
            System.out.println(replyDTO.toString());
            System.out.println("리플 작성 성공~~~~");
            return "redirect:/store/" + storeId;
        }
        System.out.println("리플 작성 실패 ~~~~");
        return "redirect:/store/" + storeId;
    }

    // 답글 수정
    @PostMapping("/{reviewId}/reply/{replyId}")
    public String updateReply(@PathVariable int reviewId,
                              @PathVariable int replyId,
                              String replyText,
                              int storeId) {
        boolean success = service.updateReply(replyText, replyId);
        if (success) {
            System.out.println("리플 수정 성공~~~~");
            return "redirect:/store/" + storeId;
        }
        System.out.println("리플 작성 실패 ~~~~");
        return "redirect:/store/" + storeId;
    }

    // 답글 삭제
    @PostMapping("/reply/{replyId}")
    public String updateReply(@PathVariable int replyId,
                              int storeId) {
        boolean success = service.deleteReply(replyId);
        if (success) {
            System.out.println("리플 삭제 성공~~~~");
            return "redirect:/store/" + storeId;
        }
        System.out.println("리플 삭제 실패 ~~~~");
        return "redirect:/store/" + storeId;
    }
}


