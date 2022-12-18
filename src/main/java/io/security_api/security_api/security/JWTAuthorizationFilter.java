package io.security_api.security_api.security;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@Component @Slf4j
public class JWTAuthorizationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String bearerToken=request.getHeader("Authorization");
        if(bearerToken !=null && bearerToken.startsWith("Bearer")){
          String token=bearerToken.replace("Bearer","");
          log.info("rempl {} to the database..."+token);
          UsernamePasswordAuthenticationToken usernamePAT=TokenUtils.getAuthentication(token);
          SecurityContextHolder.getContext().setAuthentication(usernamePAT);
        }

        filterChain.doFilter(request, response);
    }
    
}
