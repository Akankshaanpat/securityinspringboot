package com.demo.secure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	// authentication

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean UserDetailsService userDetailsService() { UserDetails admin =
	 * User.withUsername("akanksha").password(passwordEncoder().encode("password")).
	 * roles("ADMIN") .build();
	 */
	
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails admin = User.withUsername("akanksha").password(passwordEncoder().encode("password")).roles("ADMIN").build();
		UserDetails user = User.withUsername("siddhi").password(passwordEncoder().encode("pass")).roles("USER").build();
		return new InMemoryUserDetailsManager(admin, user);

	}

//Authorization


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity.csrf(c -> c.disable()).cors(c -> c.disable()).authorizeHttpRequests(h -> h.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults());
		return httpSecurity.build();
	}
}
