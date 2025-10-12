package com.artemrogov.secure_login_gateway.config;


import com.artemrogov.secure_login_gateway.dto.ExceptionBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@Slf4j
public class ConfigureSecurity {

    private final ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)                              // Отключаем CSRF-защиту
                .authorizeHttpRequests(authz -> authz.requestMatchers("/api/profiles/no-auth/**").permitAll().anyRequest().authenticated())  // Авторизация всех запросов
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))  // Stateless сессия
                .cors(withDefaults())                                       // CORS включен по умолчанию
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()))  // Настройки OAuth2 Resource Server
                .exceptionHandling(exceptions -> exceptions.authenticationEntryPoint((req, resp, exc) -> {
                    log.warn("Unauthorized attempt to access {}", req.getRequestURI(), exc);
                    resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    resp.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    resp.getWriter().print(objectMapper.writeValueAsString(new ExceptionBody("JWT token is invalid or missing")));
                }));
        return http.build();
    }

}
