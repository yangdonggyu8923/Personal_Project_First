package com.lawmate.personalproject.common.security.model.service;
import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.lawyer.model.LawyerDto;
import com.lawmate.personalproject.lawyer.repository.LawyerRepository;
import com.lawmate.personalproject.user.model.UserDto;
import com.lawmate.personalproject.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository repository;
    private LawyerRepository lawyerRepository;


    @Override
    public Messenger login(UserDto dto) {

        boolean flag = repository.findByUsername
                (dto.getUsername()).get().getPassword().equals(dto.getPassword());

        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? createToken(dto) : "NONE")
                .build();
    }

    public Messenger lawyerLogin(LawyerDto dto) {

        boolean flag = lawyerRepository.findByUsername
                (dto.getUsername()).get().getPassword().equals(dto.getPassword());

        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? createLawyerToken(dto) : "NONE")
                .build();
    }
    @Override
    public String createToken(UserDto user) {
        Claims claims = (Claims) Jwts.claims();
        claims.put("username", user.getUsername());

        String token = Jwts.builder()
                .claims()
                .add("iss", "lawmate.co.kr")
                .add("sub", "user Auth")
                .add("userId", user.getId())
                .add("username", user.getUsername())
                .add("job", "admin") // 관리자(ad), 소비자
                .and()
                .compact();
        log.info("로그인 성공으로 발급된 토큰 : " + token);
        return token;
    }

    @Override
    public String createLawyerToken(LawyerDto lawyerDto) {
        Claims claims = (Claims) Jwts.claims();
        claims.put("username", lawyerDto.getUsername());

        String token = Jwts.builder()
                .claims()
                .add("iss", "lawmate.co.kr")
                .add("sub", "lawyer Lawyer")
                .add("lawyerId", lawyerDto.getId())
                .add("username", lawyerDto.getUsername())
                .add("job", "admin") // 관리자(ad), 소비자
                .and()
                .compact();
        log.info("로그인 성공으로 발급된 토큰 : " + token);
        return token;
    }
}