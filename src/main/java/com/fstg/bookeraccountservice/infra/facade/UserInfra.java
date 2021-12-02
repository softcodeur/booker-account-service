package com.fstg.bookeraccountservice.infra.facade;

import java.util.List;

import com.fstg.bookeraccountservice.infra.core.AbstractInfra;
import com.fstg.bookeraccountservice.infra.entity.User;



public interface UserInfra  extends AbstractInfra {

	List<User> findAll();
	   

	User findByUsername(String username);

  
	User findById(Long id);
     
  
	void deleteById(Long id);


 
	User save(User user);

     
    User update(User user);
    
    
	int delete(User user);


    User findByUsernameWithRoles(String username);

  
	int  deleteByUsername(String username);
	
	
	
}
