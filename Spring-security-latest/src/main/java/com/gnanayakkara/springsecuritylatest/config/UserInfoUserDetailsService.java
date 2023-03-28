package com.gnanayakkara.springsecuritylatest.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gnanayakkara.springsecuritylatest.entity.UserInfo;
import com.gnanayakkara.springsecuritylatest.reposotory.UserInfoRepository;

/*
 * 28 Mar 2023
 */

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserInfo> userInfo = userInfoRepository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new)
			.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
	}

}
