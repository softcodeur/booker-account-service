package com.fstg.bookeraccountservice.application.converter;

import com.fstg.bookeraccountservice.application.dto.UserDto;
import com.fstg.bookeraccountservice.infra.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        } else {
            User item = new User();
            item.setUsername(dto.getUsername());
            item.setEmail(dto.getEmail());
            item.setPassword(dto.getPassword());
            item.setRoles(dto.getRoles());
            item.setRef(dto.getRef());
            item.setFirstName(dto.getFirstName());
            item.setLastName(dto.getLastName());
            return item;
        }
    }


    @Override
    public UserDto toDto(User item) {
        if (item == null) {
            return null;
        } else {
            UserDto dto = new UserDto();
            dto.setUsername(item.getUsername());
            dto.setRoles(item.getRoles());
            dto.setEmail(item.getEmail());
            dto.setCreatedAt(item.getCreatedAt());
            dto.setRef(item.getRef());
            dto.setUpdatedAt(item.getUpdatedAt());
            dto.setFirstName(item.getFirstName());
            dto.setLastName(item.getLastName());
            return dto;
        }
    }

}
