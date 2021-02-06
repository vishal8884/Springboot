package com.vishal.loginLogout.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vishal.loginLogout.service.UserDetailsServiceImpl;


@EnableWebSecurity
@Configuration
@Order(2)
public class SpringBootUserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("users")
//		.password("users")
//		.roles("USER");
//		
//	}
	
//	@Bean
//	public UserDetailsService  getUserDetailService() {
//		return new UserDetailsServiceImpl() ;	
//	}
	@Autowired
	UserDetailsService  getUserDetailService;
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();	
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder()//this meathod says i am okay with clear text password
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;	
	}

	
//	configure method
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/reguser","/").permitAll();
		
//		http.authorizeRequests()
//		.antMatchers("/user/**").hasAnyRole("USER","ADMIN");
		
		http
		.antMatcher("/user/*")
		.authorizeRequests().anyRequest().hasAnyAuthority("USER","ADMIN")
		.and().formLogin().loginPage("/user/login")
			.defaultSuccessUrl("/user/dashboard", true)
		.permitAll()
		.and().logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/login")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	
	http.csrf().disable();
		
		
//		 http.antMatcher("/user/*")
//         .authorizeRequests()
//         .anyRequest()
//         .hasRole("USER")
//         
//         .and()
//         .formLogin()
//         .loginPage("/user/login")
//         .defaultSuccessUrl("/user/dashboard")
//         
//         .and()
//         .logout()
//         .logoutUrl("/user/logout")
//         .logoutSuccessUrl("/user/login")
//         
//         
//         .and()
//         .exceptionHandling()
//         .accessDeniedPage("/403")
//         
//         .and()
//         .csrf().disable();

	}
}