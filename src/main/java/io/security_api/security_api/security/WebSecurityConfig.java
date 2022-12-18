package io.security_api.security_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

   private final UserDetailsService userDetailsService;
   private final JWTAuthorizationFilter jwtAuthorizationFilter;


    @Bean 
    SecurityFilterChain filterChain(HttpSecurity http,AuthenticationManager authManager)throws Exception{
         JWTAuthenticationFilter jwtAuthenticationFilter =new JWTAuthenticationFilter();
         jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
      
        return http
             .csrf().disable()
            .authorizeRequests()
             .anyRequest()
             .authenticated()
             .and()
             .httpBasic()
             .and()
             .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .addFilter(jwtAuthenticationFilter)//authentifica
             .addFilterBefore(jwtAuthorizationFilter,UsernamePasswordAuthenticationFilter.class)//autoriza
             .build();
    }
 /*
  * 
    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
         manager.createUser(User.withUsername("admin")
           .password(passwordEncoder().encode("admin"))
           .roles()
           .build());
                                                                
        return manager;
    }
 */

    @Bean
    AuthenticationManager authManager(HttpSecurity http)throws Exception{
         return http.getSharedObject(AuthenticationManagerBuilder.class)
                 .userDetailsService(userDetailsService)
                 .passwordEncoder(passwordEncoder())
                 .and()
                 .build();
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

/* se codifica en BCryptPasswordEncoder()
 *     public static void main(String[] args) {
        System.out.println("pass:"+ new BCryptPasswordEncoder().encode("xavier"));
    }
    $2a$10$HC3YooLSmKbQhiFGP2jApO85gilcnawVvZ0Ybxb25O6ENkVlamS3W == "xavier"
 */
    
}
