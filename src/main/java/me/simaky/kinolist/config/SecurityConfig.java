package me.simaky.kinolist.config;

import me.simaky.kinolist.converter.UserConverter;
import me.simaky.kinolist.dto.ApiExceptionDto;
import me.simaky.kinolist.dto.KinolistUserPrincipal;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.util.JsonUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public SecurityConfig(@Qualifier("kinolistUserDetailsService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .formLogin().loginProcessingUrl("/login").failureHandler((httpServletRequest, httpServletResponse, e) -> {
            if (e instanceof BadCredentialsException) {
                httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                httpServletResponse.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
                ApiExceptionDto apiExceptionDto
                        = new ApiExceptionDto(HttpServletResponse.SC_BAD_REQUEST, "wrong username or password", ApiExceptionDto.getTimeNow());
                httpServletResponse.getWriter().println(JsonUtil.toJson(apiExceptionDto));
            }
        }).successHandler((httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            httpServletResponse.setHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
            UserDto userDto = UserConverter.toDto(((KinolistUserPrincipal) authentication.getPrincipal()).getUser());
            httpServletResponse.getWriter().print(JsonUtil.toJson(userDto));

        })
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID");
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));

        configuration.setAllowCredentials(true);

        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
