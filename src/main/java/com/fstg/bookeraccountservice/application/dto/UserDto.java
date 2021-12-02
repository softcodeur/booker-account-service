package com.fstg.bookeraccountservice.application.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.fstg.bookeraccountservice.infra.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	    private Long id;
	    private boolean credentialsNonExpired;
	    private boolean enabled;
	    private Date createdAt;
	    private Date updatedAt;
	    private String email;
	    private boolean accountNonExpired;
	    private boolean accountNonLocked;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lasName;
	    private boolean passwordChanged;

	    private  Collection<Role> roles = new ArrayList<>();
	   	private Collection<Role> authorities;
}
