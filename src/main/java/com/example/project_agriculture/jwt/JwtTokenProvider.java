package com.example.project_agriculture.jwt;

import com.example.project_agriculture.cache.ram.CacheRefreshToken;
import com.example.project_agriculture.entity.Users;
import com.example.project_agriculture.security.UserDetailsImpl;
import com.example.project_agriculture.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_SECRET = "e_196t_20201006";

    private final long JWT_EXPIRATION = 1000*60*30;
    private final long JWT_REFRESH_EXPIRATION = 1000*60*60*24*7;

    public String generateToken(Authentication authentication) {
        Date expiryDate = new Date(System.currentTimeMillis() + JWT_EXPIRATION);
        UserDetailsImpl usersPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        try {
            return Jwts.builder().setSubject(new ObjectMapper().writeValueAsString(usersPrincipal.getUsers()))
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                    .compact();
        } catch (Exception ex) {
            return ex.toString();
        }
    }

    public String generateJwtToken(UserDetailsImpl userPrincipal) {
        return generateTokenFromUsername(userPrincipal.getUsername());
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION)).signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }



    public String generateRefreshToken() {
        String refreshToken = StringUtils.generateUUID();
        CacheRefreshToken.saveRefreshTokenExpired(refreshToken, System.currentTimeMillis()+JWT_REFRESH_EXPIRATION);
        return refreshToken;
    }

    public Users getAccountFromJwt(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            return new ObjectMapper().readValue(claims.getSubject(), Users.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new Users();
        }
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty");
        }
        return false;
    }
}

