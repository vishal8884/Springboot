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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
@Configuration
@Order(1)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		//set your config on auth object
//		auth.inMemoryAuthentication()
//		.withUser("roots")
//		.password("roots")
//		.roles("ADMIN");
//		
//	}
	@Autowired
	UserDetailsService getUserDetailService;
	
	@Bean
	public PasswordEncoder passwordEncoder()//this meathod says i am okay with clear text password
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailService);
		System.out.println(getUserDetailService.loadUserByUsername("admin"));
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;	
	}

	
//	configure method
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/reguser","/").permitAll();
		
//		http.authorizeRequests()
//		.antMatchers("/admin/*").hasAnyRole("ADMIN");
		
		http
		.antMatcher("/admin/**")
		.authorizeRequests().anyRequest().hasAnyAuthority("ADMIN")  //before it was .aunthicated
		.and().formLogin().loginPage("/admin/login")
			.defaultSuccessUrl("/admin/dashboard", true)
		.permitAll()
		.and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login")
		.and()
		.exceptionHandling().accessDeniedPage("/403");
		
	http.csrf().disable();
		
		
//	http.antMatcher("/admin*")
//    .authorizeRequests()
//    .anyRequest()
//    .hasRole("ADMIN")
//    
//    .and()
//    .formLogin()
//    .loginPage("/admin/login")
//    .defaultSuccessUrl("/admin/dashboard")
//    
//    .and()
//    .logout()
//    .logoutUrl("/admin/logout")
//    .logoutSuccessUrl("/admin/login")
//    
//    .and()
//    .exceptionHandling()
//    .accessDeniedPage("/403")
//    
//    .and()
//    .csrf().disable();

	}


	

}
