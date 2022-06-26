package com.cos.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.blog.config.auth.PrincipalDetailService;
//밑의 3개는 는 세트로 따라오니 걍 이해가 어려우면 외우자
@Configuration//빈등록 Ioc관리
@EnableWebSecurity//시큐리티 필터가 등록된다
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean//IOc가 됨
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	
	//시큐리티가 대신 로그인을 해주는데 password를 가로챔
	//해당 패스원드가 뭘로 해쉬되어있는지 알아야 같은 해쉬로 암호화 하여 디비의 패스워드와 비교 가능
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable() //csrf토큰 비활성화 (테스트시 걸어두는 것이 좋다)
			.authorizeRequests()//요청이 들어오며
			.antMatchers("/","/auth/**","/js/**","/css/**","/image/**")//요주소와 맞으면
			.permitAll()//모두 허요
			.anyRequest()//다른 요청들은
			.authenticated()//인증이 되어있어야 허용
			.and()//그리고 추가로
			.formLogin()//인증 안된곳으로 요청시에는 로그인 폼으로 이동
			.loginPage("/auth/loginForm")//해당 로그인 페이지의 위치
			.loginProcessingUrl("/auth/loginProc")//스프링 시큐리티가 해당 주소로 오는 로그인요청을 가로체 대신 로그인 시켜준다
			.defaultSuccessUrl("/");
	}
	
	
}
