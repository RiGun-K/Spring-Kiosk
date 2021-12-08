package com.example.teamproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.teamproject.service.UserDetailsServiceImpl;


// 페이지 권한 설정

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetails;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	  public void configure(WebSecurity web) throws Exception { 
	    web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
	}
	
	 @Override
	  protected void configure(HttpSecurity http) throws Exception { // 5
	    http
	        .authorizeRequests() // 6
	            .antMatchers("/login", "/register", "/index").permitAll() // 누구나 접근 허용
	            .antMatchers("/main", "/pregister", "/pcheck", "/pmodify", "/pcheck/{menuid}", "/pstats").hasRole("admin") // USER, ADMIN만 접근 가능
	            .antMatchers("/**").permitAll()		// 위 경우를 빼고 모든 권한을 줌 = 로그인 필요 X
	            .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
	         .and()
	         	.csrf()
	         	// 아래 주소들은 POST 방식의 Security 접근 허용 
	         	.ignoringAntMatchers("/api/pregister")
	         	.ignoringAntMatchers("/pcheck")
	         	.ignoringAntMatchers("/pmodify")
	         	.ignoringAntMatchers("/api/index")
	         	.ignoringAntMatchers("/api/odetail")
	         	.ignoringAntMatchers("/api/modify")
	         	.ignoringAntMatchers("/api/delete")
	         	.ignoringAntMatchers("/api/index")

	         	.and()
	         .formLogin()
	         	.loginPage("/login")
	         	.defaultSuccessUrl("/main")
	         	.permitAll()
	         	.and()
	         .logout() // 8
	          	.logoutUrl("/logout")
	            .logoutSuccessUrl("/") // 로그아웃 성공시 리다이렉트 주소
	            .invalidateHttpSession(true) // 세션 날리기
	            .and()
	         .exceptionHandling()
	          	.accessDeniedPage("/denied");
	          	
	  }
	
}
