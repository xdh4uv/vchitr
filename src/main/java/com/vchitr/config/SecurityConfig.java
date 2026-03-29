package com.vchitr.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    /**
     * we have disabled the csrf ( cross site request forgery because we are not using cookies. csrf is used to protect from attacks on browser when using sessions or cookies
     * we are using jwt which are stateless -> each request has to prove that it is authenticated. no states/sessions being stored for authorization.
     * therefore, in sessionManagement, we use session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
     * IF_REQUIRED means that the session will be maintained only while we are getting the info from google. After the information is retrieved we need to map a controller to '/'
     * the authentication is now stored in a http session by spring and redirects it to -> '/'
     * */
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**", "/oauth2/**").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> {});

        return http.build();
    }

}
