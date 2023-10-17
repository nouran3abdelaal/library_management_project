package com.example.moiveAppMicroservice.conf;

import com.example.moiveAppMicroservice.exceptions.JwtTokenValidationException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        try {
            final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
            final String jwt;
            final String userEmail;
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                System.out.println("authHeader == null ");
                filterChain.doFilter(request, response);
                return;
            }
            jwt = authHeader.substring(7);
//            userEmail = jwtService.extractUsername(jwt);
            if ( SecurityContextHolder.getContext().getAuthentication() == null) {
                System.out.println("userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null ");

                if (jwtService.isTokenValid(jwt)) {
                    System.out.println("jwtService.isTokenValid(jwt)");

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            null,
                            null,
                            jwtService.getAuthorities()
                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
                System.out.println("here");
            }
            filterChain.doFilter(request, response);

    } catch (Exception e) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}