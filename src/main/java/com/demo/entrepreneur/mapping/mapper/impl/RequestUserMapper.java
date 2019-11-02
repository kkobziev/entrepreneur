package com.demo.entrepreneur.mapping.mapper.impl;

import com.demo.entrepreneur.dto.user.RequestUserDto;
import com.demo.entrepreneur.entity.User;
import com.demo.entrepreneur.mapping.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class RequestUserMapper implements Mapper<RequestUserDto, User> {

    @Override
    public RequestUserDto entityToData(User entity) {
        return RequestUserDto.builder()// @formatter:off
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .login(entity.getLogin())
                .password(entity.getPassword()).build();// @formatter:on
    }

}
