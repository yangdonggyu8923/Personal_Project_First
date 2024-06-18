package com.lawmate.personalproject.common.component;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Messenger {   // Vo가 붙으면 컴포넌트, 없으면 엔티티
    private String message;
    private int status;
    private String accessToken;
    private String refreshToken;
    private Long id;
}
