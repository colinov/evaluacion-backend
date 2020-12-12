package com.bcp.demo.evaluacion.backend.authorization;

//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.security.authentication.jaas.JaasGrantedAuthority;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;

//@Component
public class AuthorizationUserDetailsService
//implements UserDetailsService 
{
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new UserDetails() {
//
//			@Override
//			public boolean isEnabled() {
//				return true;
//			}
//
//			@Override
//			public boolean isCredentialsNonExpired() {
//				return false;
//			}
//
//			@Override
//			public boolean isAccountNonLocked() {
//				return false;
//			}
//
//			@Override
//			public boolean isAccountNonExpired() {
//				return false;
//			}
//
//			@Override
//			public String getUsername() {
//				return "userdemo";
//			}
//
//			@Override
//			public String getPassword() {
//				return null;
//			}
//
//			@Override
//			public Collection<? extends GrantedAuthority> getAuthorities() {
//				JaasGrantedAuthority authority = new JaasGrantedAuthority("role", new Principal() {
//
//					@Override
//					public String getName() {
//						return "userDEmo";
//					}
//				});
//				List<JaasGrantedAuthority> list = new ArrayList<JaasGrantedAuthority>();
//				list.add(authority);
//				return list;
//			}
//		};
//	}
}
