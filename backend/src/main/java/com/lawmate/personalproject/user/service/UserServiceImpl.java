package com.lawmate.personalproject.user.service;

import com.lawmate.personalproject.common.component.security.JwtProvider;
import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.user.model.User;
import com.lawmate.personalproject.user.model.UserDto;
import com.lawmate.personalproject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final JwtProvider jwtProvider;


    @Override
    public Messenger save(UserDto userDto) {
        repository.save(dtoToEntity(userDto));
        return Messenger.builder().message("SUCCESS").build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return Messenger.builder()
                .message(repository.findById(id).isPresent() ? "SUCCESS" : "FAILURE")
                .build();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return repository.findByName(name);
    }

    @Transactional
    @Override
    public Messenger modify(UserDto userDto) {
        repository.save(dtoToEntity(userDto));

        return Messenger.builder()
                .message("SUCCESS")
                .build();
    }

    @Transactional
    @Override
    public Messenger login(UserDto userDto) {
        log.info("로그인 서비스로 들어온 파라미터 : " + userDto);
        User user = repository.findByUsername(userDto.getUsername()).get();
        String accessToken = jwtProvider.createToken(entityToDto(user));
        boolean flag = user.getPassword().equals(userDto.getPassword());
        repository.modifyTokenById(user.getId(), accessToken);
        jwtProvider.printPayload(accessToken);

        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? accessToken : "NONE")
                .build();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAllByOrderByIdDesc().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return repository.findById(id).stream().map(i->entityToDto(i)).findAny();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Transactional
    @Override
    public Boolean logout(String token) {
        String accessToken = token != null && token.startsWith("Bearer ") ?
                token.substring(7) : "undefined";
        Long id = jwtProvider.getPayload(accessToken).get("userId", Long.class);
        String deleteToken = "";
        repository.modifyTokenById(id,deleteToken);
        return repository.findById(id).get().getToken().equals("");
    }

    @Override
    public Boolean existsByUsername(String username)  {
        return repository.existsByUsername(username);
    }

    @Transactional
    @Override
    public Messenger update(UserDto userDto) {
     User user = repository.findById(userDto.getId()).get();
        if (userDto.getUsername() != null && !userDto.getUsername().equals("")) {
            user.setUsername(userDto.getUsername());
            user.setName(userDto.getName());
        }

        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        repository.save(user);

        return repository.findById(userDto.getId()).get().equals(user) ?
                Messenger.builder().message("SUCCESS").build() :
                Messenger.builder().message("FAILURE").build();
    }

//    @Override
//    public List<UserDto> getUsersById() {
//        return repository.getUsersById()
//                .stream().map(i->entityToDto(i))
//                .toList();
//    }
}

