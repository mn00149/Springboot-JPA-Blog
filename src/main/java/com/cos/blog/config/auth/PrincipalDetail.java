package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;
//스프링 시큐리티가 로그인요청을 가로채 로그인을 진행하고 완료가 되면 UserDetails타입의 오브젝트를 
//스프링 시큐리티의 고유한 세션저장소에 저장을 해준다
public class PrincipalDetail implements UserDetails {

	private User user;//콤포지션 => 객체를 품고 잇는 것

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	//계정이 만료되지 않았는지 리턴 (true=만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	//계정이 잠겨있지 않은지 리턴(true=잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	//비번이 만료되었는 지 리턴(true=만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	//게정이 활성화 상태인지 리턴(true=활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	//계정이 갖곧있는 권한 목록을 리턴한다 (권한 목록이 여러개이면 루프를 돌려야 겠지만 우리는 하나라 루프는 안써도 됨)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collectors = new ArrayList<>();
		//GrantedAuthority는 추상메서드를 한개만 가진 인터페이스이다 따라서 굳이 인터페이스를 불러오지 않고 메서드만 불러오자=> 람다식 활용
		collectors.add(()->{return "ROLE_"+user.getRole();});
		return collectors;
	}
	
}
