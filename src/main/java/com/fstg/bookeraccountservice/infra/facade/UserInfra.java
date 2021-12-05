package com.fstg.bookeraccountservice.infra.facade;

import com.fstg.bookeraccountservice.infra.core.AbstractInfra;
import com.fstg.bookeraccountservice.infra.entity.User;

import java.util.List;


public interface UserInfra extends AbstractInfra {

    List<User> findAll();


    User findByUsername(String username);


    User findById(Long id);


    void deleteById(Long id);


    User save(User user);


    User update(User user);

    boolean existByRef(String ref);

    int delete(User user);



    int deleteByUsername(String username);


}
