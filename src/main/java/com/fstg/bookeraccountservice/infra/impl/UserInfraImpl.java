package com.fstg.bookeraccountservice.infra.impl;

import com.fstg.bookeraccountservice.infra.core.AbstractInfraImpl;
import com.fstg.bookeraccountservice.infra.dao.UserDao;
import com.fstg.bookeraccountservice.infra.entity.Role;
import com.fstg.bookeraccountservice.infra.entity.User;
import com.fstg.bookeraccountservice.infra.facade.RoleInfra;
import com.fstg.bookeraccountservice.infra.facade.UserInfra;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@RequiredArgsConstructor
public class UserInfraImpl extends AbstractInfraImpl implements UserInfra, UserDetailsService {

    private final UserDao userDao;

    private final RoleInfra roleService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        if (username == null)
            return null;
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public int deleteByUsername(String username) {
        return userDao.deleteByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User save(User user) {
        User foundedUserByUsername = findByUsername(user.getUsername());
        User foundedUserByEmail = userDao.findByEmail(user.getEmail());
        if (foundedUserByUsername != null || foundedUserByEmail != null)
            return null;
        else {
            if (user.getPassword() == null || user.getPassword().isEmpty()) {
                user.setPassword((user.getUsername()));
            }
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setPasswordChanged(false);
            if (user.getRoles() != null) {
                List<Role> roles = new ArrayList<>();
                user.getRoles().forEach(role -> roles.add(roleService.save(role)));
                user.setRoles(roles);
            }
            return userDao.save(user);
        }
    }

    @Override
    public User update(User user) {
        User foundedUser = userDao.findByUsername(user.getUsername());
        if (foundedUser == null)
            return null;
        else {
            foundedUser.setEmail(user.getEmail());
            foundedUser.setUsername(user.getUsername());
            foundedUser.setEnabled(user.isEnabled());
            foundedUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
            foundedUser.setAccountNonLocked(user.isAccountNonLocked());
            foundedUser.setAccountNonExpired(user.isAccountNonExpired());
            foundedUser.setAuthorities(new ArrayList<>());
            return userDao.save(foundedUser);
        }

    }

    @Override
    public boolean existByRef(String ref) {
        return userDao.existsByRef(ref);
    }

    @Override
    @Transactional
    public int delete(User user) {
        if (user.getUsername() == null)
            return -1;
        User foundedUser = findByUsername(user.getUsername());
        if (foundedUser == null)
            return -1;
        userDao.delete(foundedUser);
        return 1;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }

    @Override
    public String getMessage(String code) {
        return null;
    }

}
