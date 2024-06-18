package com.lawmate.personalproject.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String token;
}
