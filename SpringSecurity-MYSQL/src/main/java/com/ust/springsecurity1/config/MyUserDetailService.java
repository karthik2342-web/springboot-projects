package com.ust.springsecurity1.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.springsecurity1.model.MyUser;
import com.ust.springsecurity1.repository.UserRepository;
@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
		Optional<MyUser> user=repository.findByUsername(username);
		System.out.print(user.get().getUsername());
		return user.map(MyUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("user not found" +username));
		
	}
}
