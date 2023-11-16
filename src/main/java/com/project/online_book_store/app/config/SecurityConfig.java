package com.project.online_book_store.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

/*
Добавляем security, чтобы запросы были разграничены между пользователями. Здесь прописываем у кого какая
роль, какие запросы ограничиваем, то есть авторизация. Для пароля мы используем decoder, так как это личная информация.
И также сравнение username и password из бд.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/user/**")
                .hasAnyRole("ADMIN", "USER")
                .antMatchers("/admin/**")
                .hasAnyRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .formLogin(form -> form
                        .loginPage("/api/login")
                        .permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .authoritiesByUsernameQuery("select USERNAME, ROLE from account where USERNAME=?")
                .usersByUsernameQuery("select USERNAME, PASSWORD, ENABLED from account where USERNAME=?");
    }
}