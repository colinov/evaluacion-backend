package com.bcp.demo.evaluacion.backend.authorization;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
//import org.springframework.security.oauth2.provider.token.TokenStore;

public class OAuthConfigServer
//extends AuthorizationServerConfigurerAdapter 
{
//
//	private static String REALM = "CRM_REALM";
//
//	private static final int THIRTY_MINUTES = 60 * 30;
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(OAuthConfigServer.class);
//
//	@Autowired
//	private TokenStore tokenStore;
//
//	@Autowired
//	private UserApprovalHandler userApprovalHandler;
//
//	@Autowired
//	private AuthorizationUserDetailsService userDetailsService;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//		LOGGER.info("/////////////////////////");
//		int defaultSessionTime = 300;
//		int adminSessionTime = 300;
//
//		clients.inMemory().withClient("username").secret("secret")
//				.authorizedGrantTypes("password", "refesh_token").authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//				.scopes("read", "write", "trust").accessTokenValiditySeconds(defaultSessionTime)
//				.refreshTokenValiditySeconds(THIRTY_MINUTES).and().withClient("admin").secret("secret")
//				.authorities("password", "refresh_token").authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//				.scopes("read", "write", "trust").accessTokenValiditySeconds(adminSessionTime)
//				.refreshTokenValiditySeconds(THIRTY_MINUTES);
//	}
//
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
//				.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
//	}
//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.realm(REALM);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
}
