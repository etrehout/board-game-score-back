package board.game.score.back.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import board.game.score.back.handler.CustomAuthenticationFailureHandler;
import board.game.score.back.handler.CustomAuthenticationSuccessHandler;
import board.game.score.back.handler.CustomLogoutSuccessHandler;
import board.game.score.back.security.CustomAuthenticationManager;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors()
                .and().authenticationManager(new CustomAuthenticationManager(userDetailsService, passwordEncoder))
                .formLogin().successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler()).loginProcessingUrl("/login")
                .and().logout().logoutSuccessHandler(logoutSuccessHandler());
        return http.build();
    }

    @Bean
    AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }

}
