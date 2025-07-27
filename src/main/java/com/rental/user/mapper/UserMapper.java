package com.rental.user.mapper;

import com.rental.user.appuser.dto.response.SimpleUserDto;
import com.rental.user.appuser.dto.response.UserDto;
import com.rental.user.appuser.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user){
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );
    }

    public SimpleUserDto toSimpleDto(User user){
        return new SimpleUserDto(
                user.getId(),
                user.getEmail()
        );
    }

}
