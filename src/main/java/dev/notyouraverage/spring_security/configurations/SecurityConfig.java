package dev.notyouraverage.spring_security.configurations;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/api/**")
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/**").authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher(antMatcher("/h2-console/**"))
                .authorizeHttpRequests(auth -> auth.requestMatchers(antMatcher("/h2-console/**")).permitAll())
                .csrf(crsf -> crsf.ignoringRequestMatchers(antMatcher("/h2-console/**")))
                .headers(headers -> headers.frameOptions(withDefaults()).disable())
                .build();
    }

    @Bean
    @Order(3)
    public SecurityFilterChain generalSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/oauth2/public")
                                .permitAll()
                                .requestMatchers("/")
                                .permitAll()
                                .requestMatchers(("/error"))
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .oauth2Login(withDefaults())
                .formLogin(withDefaults())
                .build();
    }
}
