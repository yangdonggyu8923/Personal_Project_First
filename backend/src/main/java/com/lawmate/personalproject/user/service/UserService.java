package com.lawmate.personalproject.user.service;

import com.lawmate.personalproject.common.component.Messenger;
import com.lawmate.personalproject.common.service.CommandService;
import com.lawmate.personalproject.common.service.QueryService;
import com.lawmate.personalproject.user.model.User;
import com.lawmate.personalproject.user.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByName(String name);
    Messenger modify(UserDto dto);
    Messenger login(UserDto param);
    Boolean logout(String accessToken);
    Boolean existsByUsername(String username);
    Messenger update(UserDto dto);

//    List<UserDto> getUsersById();

    default User dtoToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();
    }
    default UserDto entityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .phone(user.getPhone())
                .build();
    }

}
