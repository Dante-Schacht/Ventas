package com.Ventas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/ventas/**").hasAnyRole("GERENTE", "VENTAS")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
}

    @Bean
    public UserDetailsService users() {
        UserDetails gerente = User.builder()
            .username("gerente")
            .password("{noop}password123")
            .roles("GERENTE")
            .build();

        UserDetails vendedor = User.builder()
            .username("ventas")
            .password("{noop}password123")
            .roles("VENTAS")
            .build();

        return new InMemoryUserDetailsManager(gerente, vendedor);
    }
}


