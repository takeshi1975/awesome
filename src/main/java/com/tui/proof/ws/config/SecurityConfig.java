package com.tui.proof.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable()) // Desactiva CSRF para facilitar pruebas con Postman, etc.
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/**").permitAll() // Endpoint público
				.requestMatchers("/admin/**").hasRole("ADMIN") // Requiere rol ADMIN
				.anyRequest().authenticated() // El resto requiere autenticación
			)
			.httpBasic(Customizer.withDefaults()); // Autenticación básica

		return http.build();
	}

	@Bean
	public UserDetailsService users() {
		UserDetails user = User
			.withUsername("user")
			.password(passwordEncoder().encode("password"))
			.roles("USER")
			.build();

		UserDetails admin = User
			.withUsername("admin")
			.password(passwordEncoder().encode("adminpass"))
			.roles("ADMIN")
			.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
