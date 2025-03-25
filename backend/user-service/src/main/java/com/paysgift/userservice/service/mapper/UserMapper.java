package com.paysgift.userservice.service.mapper;

import com.paysgift.userservice.domain.User;
import com.paysgift.userservice.service.dto.UserDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link User} and its DTO {@link UserDTO}.
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {}
