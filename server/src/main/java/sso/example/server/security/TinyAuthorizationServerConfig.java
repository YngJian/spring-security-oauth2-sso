package sso.example.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import sso.example.server.service.impl.MyUserDetailsService;

import javax.sql.DataSource;

/**
 * 授权服务器
 * @Configuration 注入ico容器
 * @EnableAuthorizationServer 授权服务器注解
 * */
@Configuration
@EnableAuthorizationServer
public class TinyAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService tinyUserDetailService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    /**
     * 客户端配置
     * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //从数据库取
        clients.jdbc(dataSource);
    }

    /**
     * 授权端点配置
     * */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        //使用password模式
        endpoints.authenticationManager(authenticationManager);
        //设置用户验证服务。
        endpoints.userDetailsService(tinyUserDetailService);

        //设置token存储方式-redis
        endpoints.tokenStore(redisTokenStore());

//        DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
//        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//        tokenServices.setTokenStore(endpoints.getTokenStore());
//        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//        tokenServices.setSupportRefreshToken(true);
//        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 一天有效期
//        //自定义refreshToken
//        tokenServices.setRefreshTokenValue(UUID.randomUUID().toString()+"ZMHrefreshtoken");
//        //自定义access_token
//        tokenServices.setAccessTokenValue(UUID.randomUUID().toString()+"ZMHAccessToken");
//        endpoints.tokenServices(tokenServices);



//        //设置token存储方式-jwt
//        endpoints.tokenStore(jwtTokenStore()).accessTokenConverter(jwtAccessTokenConverter());
//        DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints.getDefaultAuthorizationServerTokenServices();
//        tokenServices.setTokenStore(endpoints.getTokenStore());
//        tokenServices.setSupportRefreshToken(true);
//        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 一天有效期
//        endpoints.tokenServices(tokenServices);
    }

    /**
     * 授权服务器安全配置
     * */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
        security.checkTokenAccess("isAuthenticated()");
        security.tokenKeyAccess("isAuthenticated()");

    }

    /**
     * Token设置-redis
     * */
    @Bean
    public TokenStore redisTokenStore(){
        //存入redis
        return new RedisTokenStore(redisConnectionFactory);

    }

    /**
     * Token设置-jwt
     * */
    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("test-sign-Key");
        return converter;
    }

}
