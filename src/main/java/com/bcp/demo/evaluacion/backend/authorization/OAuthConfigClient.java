package com.bcp.demo.evaluacion.backend.authorization;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.approval.ApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
//import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

public class OAuthConfigClient 
//extends ResourceServerConfigurerAdapter 
{
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(OAuthConfigClient.class);
//
//	@Autowired
//	private ClientDetailsService clientDetailsService;
//
////	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		LOGGER.info("++++++++++++++++++++++++++");
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable()
//				.authorizeRequests().antMatchers("/oauth/token").permitAll().anyRequest().authenticated().and()
//				.httpBasic().realmName("CRM_REALM");
//		http.antMatcher("/**").authorizeRequests().antMatchers("/auth/login**").permitAll();
//		http.anonymous().disable().requestMatchers().antMatchers("/exchange/rate/**").and().authorizeRequests()
//				.antMatchers("/exchange/**").access("hasRole('ADMIN') or hasRole('role')").and().exceptionHandling()
//				.accessDeniedHandler(new OAuth2AccessDeniedHandler());
//		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
//	}
//
//	@Autowired
//	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("crmadmin").password("crmpass").roles("ADMIN", "USER").and()
//				.withUser("crmuser").password("pass123").roles("USER");
//	}
//
//	@Bean
//	public TokenStore tokenStore() {
//		return new InMemoryTokenStore();
//	}
//
//	@Bean
//	@Autowired
//	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
//		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
//		handler.setTokenStore(tokenStore);
//		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
//		handler.setClientDetailsService(clientDetailsService);
//		return handler;
//	}
//
//	@Bean
//	@Autowired
//	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
//		TokenApprovalStore store = new TokenApprovalStore();
//		store.setTokenStore(tokenStore);
//		return store;
//	}

}
