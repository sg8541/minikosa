package com.kosa.mini.interceptor;

import com.kosa.mini.domain.member.UserSessionDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false); // 기존 세션이 없으면 null 반환

        if (session == null) {
            // 세션이 없으면 홈으로 리다이렉트
            response.sendRedirect("/home");
            return false;
        }

        Object loggedInUserObj = session.getAttribute("loggedInUser");

        if (!(loggedInUserObj instanceof UserSessionDTO)) {
            // 세션 객체가 UserSessionDTO가 아니면 홈으로 리다이렉트
            response.sendRedirect("/home");
            return false;
        }

        UserSessionDTO loggedInUser = (UserSessionDTO) loggedInUserObj;

        // 관리자 권한 비교
        if (loggedInUser.getRoleId() != 2) {
            // 권한이 없으면 접근 거부 페이지
            response.sendRedirect("/access-denied");
            return false;
        }

        // 모든 검사를 통과
        return true;
    }
}
