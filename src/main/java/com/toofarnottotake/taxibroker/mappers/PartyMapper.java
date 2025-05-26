package com.toofarnottotake.taxibroker.mappers;

import com.toofarnottotake.taxibroker.dtos.PartyDto;
import com.toofarnottotake.taxibroker.dtos.RegisterUserRequest;
import com.toofarnottotake.taxibroker.dtos.UpdateUserRequest;
import com.toofarnottotake.taxibroker.entities.Party;
import com.toofarnottotake.taxibroker.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PartyMapper {
    PartyDto toDto(Party party);
    Party toEntity(PartyDto partyDto);
//    void update(UpdateUserRequest request, @MappingTarget User user);
}
