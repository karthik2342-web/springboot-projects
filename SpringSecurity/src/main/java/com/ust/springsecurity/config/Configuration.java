package com.ust.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
@EnableMethodSecurity
public class Configuration {
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
@Bean		
		SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
			return http.authorizeHttpRequests(registry->{
			registry.requestMatchers("/").permitAll();
			registry.requestMatchers("/admin/**").hasRole("admin");
			registry.requestMatchers("/user/**").hasRole("user");
			registry.anyRequest().authenticated();
			}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build();
		}
		@Bean
		InMemoryUserDetailsManager userDetailsServie() {
			UserDetails userdetails=User.builder().
							username("bean").
							password(passwordEncoder().encode("mister")).
							roles("user").build();
			UserDetails admindetails=User.builder().
							username("po").
							password(passwordEncoder().encode("panda")).
							roles("admin").build();
			return new InMemoryUserDetailsManager(userdetails,admindetails);
		}
		
	}

	
	
	
	
	
	
	
	
	
//	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth
//			.inMemoryAuthentication()
//			.withUser("bond")
//			.password("james")
//			.roles("user")
//			.and()
//			.withUser("polar")
//			.password("bear")
//			.roles("admin");
//	}
//	public PasswordEncoder getPasswordEncoder() {
//		@Override
//		protected void configure(HttpSecurity http) throws Exception{
//			http
//				.authorizeRequests()
//				.an
//		}
//		
//		
	

