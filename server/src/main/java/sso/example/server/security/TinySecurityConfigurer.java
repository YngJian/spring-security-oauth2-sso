package sso.example.server.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sso.example.server.service.impl.MyUserDetailsService;

/**
 * 权限控制类
 * */

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TinySecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService tinyUserDetailService;

    /**
     * 访问权限控制
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();



    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用GreyUserDetailService里返回的用户来验证
        /**
         * .passwordEncoder(new BCryptPasswordEncoder());
         * 这里可以不用这个方法，也可以在库里存{bcrypt},解密时会通过这个id查找
         * 例如：{bcrypt}$2a$10$hQv0A0Seh3Lu3mDlmSTNd.Qtd3HcdMNgisRadM.8igtE5BwAmBEKe
         * */
        auth.userDetailsService(tinyUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.tml","/user/*.tml");
    }
}
