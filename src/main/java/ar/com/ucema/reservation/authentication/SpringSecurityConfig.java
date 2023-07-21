package ar.com.ucema.reservation.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //Deshabilita la protección CSRF (Cross-Site Request Forgery)
                .csrf().disable()
                .cors().and()
                //Establece la creación de sesiones en STATELESS, la aplicación no cree sesiones de usuario
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //Inicia la configuración de las reglas de autorización de las solicitudes HTTP
                .authorizeHttpRequests()
                // Establece que cualquiera puede ejecutar los endpoints de esa ruta
                .requestMatchers("/api/auth/**", "/v3/api-docs", "/swagger-ui/**", "/swagger-resources/**",
                        "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/activity-profiles/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/activity-profiles").permitAll()
                // Para cualquier otra request, debe haber un usuario autenticado.
                .anyRequest().authenticated()
                .and().exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint); // manejo exception cuando falle la autenticación
        // Agregamos un filtro personalizado
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
