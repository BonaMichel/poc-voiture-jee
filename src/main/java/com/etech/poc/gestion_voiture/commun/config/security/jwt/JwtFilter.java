package com.etech.poc.gestion_voiture.commun.config.security.jwt;

import com.etech.poc.gestion_voiture.service.metier.read.user.UserRSMImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author bona
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserRSMImpl userRSMImpl;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filter) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(JwtProperties.HEADER_STRING);

        String token = null;
        String userName = null;

        if (authorizationHeader != null && authorizationHeader.startsWith(JwtProperties.TOKEN_PREFIX)) {
            token = authorizationHeader.substring(7);
            userName = jwtUtil.extractUsername(token);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userRSMImpl.loadUserByUsername(userName);

            if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken userPAuth
                        = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userPAuth
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userPAuth);
            }
        }
        response.setHeader("Authorization", authorizationHeader);
        filter.doFilter(request, response);
    }

}
