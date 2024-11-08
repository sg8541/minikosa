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
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("/home");
            return false;
        }

        Object loggedInUserObj = session.getAttribute("loggedInUser");

        if (!(loggedInUserObj instanceof UserSessionDTO)) {
            response.sendRedirect("/home");
            return false;
        }

        UserSessionDTO loggedInUser = (UserSessionDTO) loggedInUserObj;

        if (!loggedInUser.getRoleId().equals(2)) {
            response.sendRedirect("/access-denied");
            return false;
        }

        return true;
    }
}

