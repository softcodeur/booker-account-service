package com.fstg.bookeraccountservice.application.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bookeraccountservice.application.converter.AbstractConverter;
import com.fstg.bookeraccountservice.application.dto.UserDto;
import com.fstg.bookeraccountservice.infra.entity.User;
import com.fstg.bookeraccountservice.infra.facade.UserInfra;



@RequestMapping("/api/v1/account")
@RestController
public class UserRest {
	@Autowired
	private UserInfra userService;
	
	   @Autowired
	    @Qualifier("userConverter")
	    private AbstractConverter<User, UserDto> userConverter;
	   
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
	@GetMapping("/")
	public List<User> findAll(){
		   return this.userService.findAll();
		}

	public UserDto findByUsername(String username) {
		return userConverter.toVo(userService.findByUsername(username));
	}
     @GetMapping("/{id}")
	public UserDto findById(@PathVariable Long id) {
		return userConverter.toVo(userService.findById(id));
	}
     @DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
	}
     
    @PostMapping("/save")
	public UserDto save(@RequestBody UserDto userDto) {
    	User user = userConverter.toItem(userDto);
		return userConverter.toVo(userService.save(user));
	}
     @PutMapping("/")
	public UserDto update(@RequestBody UserDto userDto) {
    	 User user = userConverter.toItem(userDto);
		return userConverter.toVo(userService.update(user));
	}
    @DeleteMapping("/")
	public int delete(@RequestBody UserDto userDto) {
    	 User user = userConverter.toItem(userDto);
		return userService.delete(user);
	}

     @GetMapping("/username/{username}")
	public UserDto findByUsernameWithRoles(@PathVariable String username) {
		return userConverter.toVo(userService.findByUsernameWithRoles(username));
	}

    @DeleteMapping("/username/{username}")
	public int deleteByUsername(@PathVariable String username) {
		return userService.deleteByUsername(username);
	}
	
	
	
	
	

}
