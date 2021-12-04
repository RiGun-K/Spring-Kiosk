package com.example.teamproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.teamproject.repository.UserRepository;

// 사용자 정보 조회 
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
										// 입력받은 userid 값을 가져옴
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// User 테이블의 username 값 ( userid ) 과 비교
		Optional<com.example.teamproject.data.User> dbuser = userRepository.findById(username);
		if(dbuser.isEmpty()) {
			throw new UsernameNotFoundException("Invalid username");
		}
		
		List<GrantedAuthority> auths = new ArrayList<>();
		
		// 권한 부여 
		UserDetails ud = User
				.withUsername(dbuser.get().getUserid())
				.password(dbuser.get().getPassword())
				.authorities(auths)
				.roles(dbuser.get().getRole())
				.build();
		return ud;
	}

}

