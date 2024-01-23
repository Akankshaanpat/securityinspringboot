//package com.demo.secure.config;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.demo.secure.entity.UserInfo;
//import com.demo.secure.repository.UserInfoRepository;
//@Component
//public class UserInfoUserDetailsService implements UserDetailsService {
//	@Autowired
//private UserInfoRepository repository;
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<UserInfo> userInfo = repository.findById(username);
//		return UserDetails;
//	}
//
//}
////