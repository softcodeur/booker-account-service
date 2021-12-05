package com.fstg.bookeraccountservice.application.dto;

import com.fstg.bookeraccountservice.infra.entity.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Date createdAt;
    Date updatedAt;
    String email;
    String username;
    String password;
    String firstName;
    String lastName;
    String ref;
    Collection<Role> roles = new ArrayList<>();
}
