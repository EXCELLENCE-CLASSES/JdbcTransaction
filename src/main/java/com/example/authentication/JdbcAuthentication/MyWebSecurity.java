package com.example.authentication.JdbcAuthentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class MyWebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
		DataSource datasource ;

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception 
		{
			
		
		
		    auth.jdbcAuthentication()
		    .dataSource(datasource);
		    //  .withDefaultSchema()
		    // .withUser(User.withUsername("Ritesh").password("Arya").roles("USER"))
		    //  .withUser(User.withUsername("Arya").password("Arya").roles("ADMIN"));
			
			
		}
		@Bean
		public PasswordEncoder getPasswordEncoder() 
		{
			return NoOpPasswordEncoder.getInstance();
		}
		

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
			//user can make any kind of authentication
			//http.authorizeRequests().antMatchers("/","static/css","static/js").permitAll().
			// antMatchers("/**").hasRole("ADMIN").and().formLogin();
			//or
			http.authorizeRequests()
			
		
			.antMatchers("/User").hasRole("User")
			//Admin should have both ,user role as well as admin role
			.antMatchers("/Admin").hasAnyRole("Admin","User")
			.antMatchers("/").permitAll()		
			.and()
			.formLogin();
			
			
		}
		
		
		
		
	
	

}
