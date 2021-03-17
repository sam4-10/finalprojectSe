package edu.miu.mumschedule.demo.configuration;



import edu.miu.mumschedule.demo.serviceImpl.AuctionUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;

    public SecurityConfiguration(AuctionUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(this.userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .csrf().disable()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeRequests()
                .antMatchers("/SE_Final_Project-1/SE_Final_Project/src/resources/static/**", "/images/**", "/css/**","/home/log_in","/user/**", "/auction/public/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
               .antMatchers("/faculty/**").hasAuthority("ROLE_FACULTY")
                .antMatchers("/student/**").hasAuthority("ROLE_STUDENT")
//                .antMatchers("/auction/secured/admin/**", "/resources/secured/admin/**", "/auction/admin/**", "/templates/secured/admin/**").hasRole("ADMIN")
//                .antMatchers("/auction/secured/seller/**", "/resources/secured/seller/**","/seller/**").hasRole("SELLER")
//                .antMatchers("/auction/secured/customer/**", "/resources/secured/customer/**","/auction/customer/**").hasRole("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/home/log_in")
                .defaultSuccessUrl("/home/")
                .failureUrl("/home/log_in?error")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/home/log_out"))
                .logoutSuccessUrl("/home/log_in?logout")
                .permitAll()
                .and()
                .exceptionHandling();
    }
}
