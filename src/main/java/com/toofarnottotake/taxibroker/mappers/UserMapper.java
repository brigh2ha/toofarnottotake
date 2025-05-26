package com.toofarnottotake.taxibroker.mappers;

import com.toofarnottotake.taxibroker.dtos.RegisterUserRequest;
import com.toofarnottotake.taxibroker.dtos.UpdateUserRequest;
import com.toofarnottotake.taxibroker.dtos.UserDto;
import com.toofarnottotake.taxibroker.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}
