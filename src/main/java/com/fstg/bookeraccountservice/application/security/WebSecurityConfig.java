package com.fstg.bookeraccountservice.application.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fstg.bookeraccountservice.application.jwt.JWTAuthenticationFilter;
import com.fstg.bookeraccountservice.application.jwt.JWTAuthorizationFiler;





@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		  prePostEnabled = true, 
		  securedEnabled = true, 
		  jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
       @Resource(name = "userService")
	   private UserDetailsService userDetailsService;
       
    
	    @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	    }
	   
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.authorizeRequests().antMatchers("/login/**", "/ums-api/user/").permitAll();
	        
            http.authorizeRequests().antMatchers("/ums-api/user/").hasAuthority("ROLE_ADMIN");
	       // http.authorizeRequests().anyRequest().authenticated();
	      
	      /* http.authorizeRequests().anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic();*/
	        
	      // http.formLogin();
           // http.authorizeRequests().anyRequest().permitAll();
	       http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	       http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
	    }
	    
	    @Bean
	    public BCryptPasswordEncoder encoder(){
	        return new BCryptPasswordEncoder();
	    }
	
	
}
