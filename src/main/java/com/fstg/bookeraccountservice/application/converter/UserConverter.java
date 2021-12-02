package com.fstg.bookeraccountservice.application.converter;

import org.springframework.stereotype.Component;

import com.fstg.bookeraccountservice.application.dto.UserDto;
import com.fstg.bookeraccountservice.infra.entity.User;

@Component
public class UserConverter extends AbstractConverter<User, UserDto> {

    @Override
    public User toItem(UserDto vo) {
        if (vo == null) {
            return null;
        } else {
            User item = new User();
            item.setUsername(vo.getUsername());
            item.setEmail(vo.getEmail());
            item.setPassword(vo.getPassword());
            item.setId(vo.getId());
            item.setAuthorities(vo.getAuthorities());
            return item;
        }
    }

  
	@Override
	public UserDto toVo(User item) {
		 if(item==null){
		        return null;
		       }else{
		           UserDto vo = new UserDto();
		            vo.setUsername(item.getUsername());
		            vo.setId(item.getId());
		            vo.setPassword(item.getPassword());
		            vo.setAuthorities(item.getAuthorities());
		            vo.setEmail(item.getEmail());
		           return vo;
		       }
	}

}
