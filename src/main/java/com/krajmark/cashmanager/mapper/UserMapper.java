package com.krajmark.cashmanager.mapper;

import com.krajmark.cashmanager.dto.RegisterFormUserDTO;
import com.krajmark.cashmanager.model.BaseUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "balance", constant = "0")
    BaseUser registrationUserDtoToUserModel(RegisterFormUserDTO userDTO);
}
