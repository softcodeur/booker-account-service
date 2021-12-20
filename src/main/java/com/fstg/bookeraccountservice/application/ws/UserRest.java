package com.fstg.bookeraccountservice.application.ws;

import com.fstg.bookeraccountservice.application.converter.UserMapper;
import com.fstg.bookeraccountservice.application.dto.UserDto;
import com.fstg.bookeraccountservice.infra.entity.User;
import com.fstg.bookeraccountservice.infra.facade.UserInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/account")
@RestController
@RequiredArgsConstructor
public class UserRest {
    private final UserInfra userService;

    private final UserMapper userMapper;

    //@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')")
    @GetMapping("/")
    public List<User> findAll() {
        return this.userService.findAll();
    }


    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        return userMapper.toDto(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.save(user));
    }

    @PutMapping("/")
    public UserDto update(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.update(user));
    }

    @GetMapping("/ref/{ref}")
    public boolean existsByRef(@PathVariable String ref) {
          System.out.println("****************************: "+ref);
    	return userService.existByRef(ref);
   
    }

    @DeleteMapping("/")
    public int delete(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userService.delete(user);
    }

    @GetMapping("/username/{username}")
    public UserDto findByUsernameWithRoles(@PathVariable String username) {
        return userMapper.toDto(userService.findByUsername(username));
    }

    @DeleteMapping("/username/{username}")
    public int deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }


}
