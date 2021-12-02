package com.fstg.bookeraccountservice.application.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
	    private Long id;
	    private Date updatedAt ;
	    private String authority ;
	    private Date createdAt ;

}
