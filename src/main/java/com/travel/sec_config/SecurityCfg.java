package com.travel.sec_config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityCfg extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource datasource;
	 @Override
	    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		 builder.jdbcAuthentication()
		 .dataSource(datasource)
		 .passwordEncoder(passwordEncoder())
		 .usersByUsernameQuery("select username, password, enabled from users where username= ? ")
		 .authoritiesByUsernameQuery("select username, role from user_roles where username= ? ")
		 ;
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/bus-journey/**").hasRole("ADMIN")
	            .antMatchers("/staff/**").hasAnyRole("ADMIN","STAFF")
	            .antMatchers("/customer/**").hasAnyRole("ADMIN","STAFF","CUSTOMER")
	            .antMatchers("/bus-journey/bookTicket/**").hasAnyRole("ADMIN","STAFF","CUSTOMER")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin().permitAll()
	            .and()
	            .logout().permitAll()
	            .and()
	            .exceptionHandling().accessDeniedPage("/403")
	            
	            ;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
