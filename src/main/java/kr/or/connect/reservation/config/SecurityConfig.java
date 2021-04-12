package kr.or.connect.reservation.config;

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

import kr.or.connect.reservation.service.security.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{ //사용자 지정 보안 구성을 원할때 상속받아서 구현한다
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	// /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시합니다.
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**");
	}
	
	
	//AuthenticationFilter가 로그인을 처리해주는 팔터, 이때 해당 정보를 데이터베이스에서 읽어 올때 UserDailsSerive를 구현하는 객체를 사용한다.
	//AuthenticationManager: 사용자 인증을 담당한다. -> 인증하는 객체를 재 정의한다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	// /, /main에 대한 요청은 누구나 할 수 있지만,
	// 그 외의 요청은 모두 인증 후 접근 가능합니다.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//				.authorizeRequests()
//				.anyRequest().permitAll()
//				.and().formLogin().loginPage("/members/loginform").usernameParameter("userId")
//				.passwordParameter("password").loginProcessingUrl("/authenticate");
	}

	// 패스워드 인코더를 빈으로 등록합니다.
	// 암호를 인코딩하거나, 인코딩된 암호와 사용자가 입력한 암호가 같은 지 확인할 때 사용합니다.
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}
