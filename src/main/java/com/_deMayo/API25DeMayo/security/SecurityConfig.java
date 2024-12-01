package com._deMayo.API25DeMayo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(customizer -> customizer
                        .requestMatchers("/api/auth/login").permitAll()
                        .requestMatchers("/api/stock/**").permitAll()
                        .requestMatchers("/api/compras/**").permitAll()
                        .requestMatchers("/api/detalleCompra/**").permitAll()
                        .requestMatchers("/api/movimientos/**").permitAll()
                        .requestMatchers("/api/detalleMovimento/**").permitAll()
                        .requestMatchers("/api/depositos/**").permitAll()
                        .requestMatchers("/api/proveedores/**").permitAll()
                        //.requestMatchers("api/stock/**").authenticated()
                        //.anyRequest().authenticated()
                        .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}