package com.mrinal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		endpoints.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// TODO Auto-generated method stub
		security.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// TODO Auto-generated method stub
		clients.inMemory().withClient("my-trusted-client")
		       .authorizedGrantTypes("authorization_code","password","refresh_token")
		       .authorities("ADMIN","ACTUATOR")
		       .scopes("read","write","trust")
		       .accessTokenValiditySeconds(120)
		       .refreshTokenValiditySeconds(1800)
		       .secret("secret");
		
		
	}
	
	

}
