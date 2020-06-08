package sso.example.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;


@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TinyResourceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private RemoteTokenServices remoteTokenServices;

    @Autowired
    private TinyAccessDeniedHandler tinyAccessDeniedHandler;
    @Autowired
    private TinyAuthenticationEntryPoint tinyAuthenticationEntryPoint;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] ignore={"/user/login.tml",
                        "/smart_recommendation.tml",
                        "/active.tml",
                        "/helpercenter.tml",
                        "/dictionary.tml",
                        "/helpercenter.tml",
                        "/reply.tml",
                        "/feedback.tml"};
        // 基于token，所以不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.antMatcher("/**").authorizeRequests()
                .and()
                .authorizeRequests()
                .antMatchers(ignore).permitAll()
//                .antMatchers("/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and().exceptionHandling()
                //添加自定义异常
                .accessDeniedHandler(tinyAccessDeniedHandler)
                .authenticationEntryPoint(tinyAuthenticationEntryPoint);
    }

    /**
     * 当token为redis方式时需要配置
     * */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(remoteTokenServices)
                //添加自定义异常
                .accessDeniedHandler(tinyAccessDeniedHandler)
                .authenticationEntryPoint(tinyAuthenticationEntryPoint);
    }





}
