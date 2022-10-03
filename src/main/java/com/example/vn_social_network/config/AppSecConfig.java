package com.example.vn_social_network.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class AppSecConfig extends WebSecurityConfigurerAdapter {

    //Xác thực
    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(userBuilder.username("hien").password("12345").roles("USER").build());
        manager.createUser(userBuilder.username("trong").password("12345").roles("ADMIN").build());
        manager.createUser(userBuilder.username("dung").password("12345").roles("ADMIN").build());
        return manager;
    }

    //Phân quyền
    //User nào thì được vào đường dẫn nào

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/","/home").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/admin").hasRole("ADMIN").and()
                .authorizeHttpRequests().antMatchers("/user").hasAnyRole("USER","ADMIN")
                .and()
                .formLogin()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/dangxuat"));
        http.csrf().disable();
    }
}
