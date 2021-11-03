package com.example.main_application_demo.application.dto.mapper;

import com.example.main_application_demo.application.dto.UserDto;
import com.example.main_application_demo.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityToDto {
    EntityToDto translate = Mappers.getMapper(com.example.main_application_demo.application.dto.mapper.EntityToDto.class);

    UserDto clone(User user);
}
