package com.lawmate.personalproject.common.config;
import com.lawmate.personalproject.common.component.interceptor.AuthInterceptor;
import com.lawmate.personalproject.common.component.interceptor.LawyerInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor;
    private final LawyerInterceptor lawyerInterceptor;

    @Override
    public void addInterceptors(@SuppressWarnings("null") InterceptorRegistry registry) {
        registry.addInterceptor(lawyerInterceptor)
//                .addPathPatterns("/api/**") // 디폴트
                .excludePathPatterns("/api/auth/**", "/api/users/**", "/api/lawyers/**", "/swagger-ui/**");

        registry.addInterceptor(authInterceptor)
//                .addPathPatterns("/api/**") // 디폴트
                .excludePathPatterns("/api/auth/**", "/api/users/**", "/api/lawyers/**", "/swagger-ui/**");
                                                        // auth를 갖고 있으면 토큰이 없어도 입장 가능
                                                      // = 인터셉터를 타지 않는다.

    }
}
