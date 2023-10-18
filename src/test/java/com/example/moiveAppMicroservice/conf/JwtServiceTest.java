package com.example.moiveAppMicroservice.conf;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtServiceTest {


    @InjectMocks
        private JwtService jwtService;



        @Test
        @DisplayName("Testing extracting All claims and non null result returned")
        void testExtractAllClaims() {
            String token = createSampleToken(1000);
            Claims claims = jwtService.extractAllClaims(token);
            assertNotNull(claims);
        }


    @Test
    void testGetAuthorities() {
        List<GrantedAuthority> authorities = jwtService.getAuthorities();

        assertEquals(1, authorities.size());
        assertEquals("ROLE_USER", authorities.get(0).getAuthority());


    }
        @Test
        @DisplayName("Testing generating a valid token")
        void testIsTokenValidWithValidToken() {
            String token = createSampleToken(1000);
            boolean isValid = jwtService.isTokenValid(token);
            assertTrue(isValid);
        }

        @Test
        @DisplayName("Testing generating a expired token")
        void testIsTokenValidWithExpiredToken() {
            String expiredToken = createSampleToken( -10000); // Expired token
            assertThrows(ExpiredJwtException.class, () -> {
                jwtService.isTokenValid(expiredToken);
            });
        }


        @Test
        @DisplayName("Testing extracting the expiration of a token")
        void testExtractExpiration() {
            String token = createSampleToken(1000);
            Date expiration = jwtService.extractExpiration(token);
            assertNotNull(expiration);
        }


        private String createSampleToken( long expirationOffset) {
            String secretKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
            return Jwts.builder()
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expirationOffset))
                    .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)), SignatureAlgorithm.HS256)
                    .compact();
        }
    }


