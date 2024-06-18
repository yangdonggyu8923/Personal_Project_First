package com.lawmate.personalproject.common.component.interceptor;

import com.lawmate.personalproject.common.component.security.JwtProvider;
import com.lawmate.personalproject.lawyer.repository.LawyerRepository;
import com.lawmate.personalproject.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtProvider jwt;
    private final UserRepository repository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {


//        String token = jwt.extractTokenFromHeader(request);
//        log.info("1- 인터셉터 토큰 로그 Bearer 포함 : {}", token);
//
//        if (token.equals("undefined")) {
//            response.sendError(HttpServletResponse.SC_ACCEPTED);
//            return false;
//        }
//
//        Long id = jwt.getPayload(token).get("userId", Long.class);
//        // get() 메모리가 아닌 .클래스 내 클레임에서 가져올 때 사용
//        log.info("2- 인터셉터 사용자 id : {}", id);
//
//        Optional<User> user = repository.findById(id);
//        log.info("3- 인터셉터 사용자 정보 {}", user);
//
//        if (!user.isPresent()) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//            return false;
//        }
//
//        log.info("4- 인터셉터 최종 여부 {}", true);

        return Stream.of(request)
                .map(i -> jwt.extractTokenFromHeader(i))
                .filter(token -> !token.equals("undefined"))
                .peek(token -> log.info("1- 인터셉터 토큰 로그 Bearer 포함 : {}", token))
                .map(token -> jwt.getPayload(token).get("userId", Long.class))
                .map(id -> repository.findById(id))
                .filter(id -> id.isPresent())
                .peek(id -> log.info("2- 인터셉터 사용자 id : {}", id))
                .findFirst()
                .isPresent();
    }   // request



    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }   // response

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }   // exception
}
