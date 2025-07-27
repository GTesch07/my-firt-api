package dio.web.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("admin123")
                .roles("MANAGERS")
                .build();

        UserDetails user = User.withUsername("user")
                .password("user123")
                .roles("USERS")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/managers").hasRole("MANAGERS")
                .requestMatchers("/operators").hasAnyRole("USERS", "MANAGERS")
                .anyRequest().authenticated()
                .and()
                .formLogin(); // ou .httpBasic() se preferir autenticação via header

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Não recomendado para produção!
        return NoOpPasswordEncoder.getInstance();
    }
}
