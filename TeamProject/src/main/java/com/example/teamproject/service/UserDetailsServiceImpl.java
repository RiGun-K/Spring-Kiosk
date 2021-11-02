package com.example.teamproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.teamproject.repository.UserRepository;

// 여기서 사용자 정보 (아이디,비밀번호,권한 등을 설정)
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws AccountNotFoundException {
		Optional<com.example.teamproject.data.User> dbuser = userRepository.findById(username);
		if(dbuser.isEmpty()) {
			throw new AccountNotFoundException("Invalid username");
		}
		
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority("QUERY"));
		if(dbuser.get().getRole().equals("admin"))
		auths.add(new SimpleGrantedAuthority("WRITE"));
	
		UserDetails ud = User
				.withUsername(dbuser.get().getUserid())
				.password(dbuser.get().getPassword())
				.authorities(auths)
				.roles(dbuser.get().getRole())
				.build();
				return ud;
	}
}
