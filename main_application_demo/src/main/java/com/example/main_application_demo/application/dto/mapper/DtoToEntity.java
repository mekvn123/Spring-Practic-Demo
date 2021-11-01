package com.example.main_application_demo.application.dto.mapper;

import com.example.main_application_demo.application.dto.UserInfoDto;
import com.example.main_application_demo.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DtoToEntity {
    DtoToEntity INSTANCE = Mappers.getMapper(DtoToEntity.class);

    User clone(UserInfoDto userInfoDto);
}
