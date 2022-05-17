package com.folcamp.bancoDeAlimentos.security.jwt;

import com.folcamp.bancoDeAlimentos.security.PrincipalUser;
import com.folcamp.bancoDeAlimentos.security.dto.JwtDto;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    private static final  Logger logger= LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        PrincipalUser principalUser= (PrincipalUser) authentication.getPrincipal();
        List<String> roles= principalUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder().setSubject(principalUser.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
            .compact();
    }
    public String getNameUserFromToken(String token){
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token) ;
            return true;
        }catch (MalformedJwtException exception){
            logger.error("token mal formado"+exception.getMessage());
        }catch (UnsupportedJwtException exception){
            logger.error("token no soportado"+exception.getMessage());
        }catch (ExpiredJwtException exception){
            logger.error("token expirado"+exception.getMessage());
        }catch (IllegalArgumentException exception){
            logger.error("token vacio"+exception.getMessage());
        }catch (SignatureException exception){
            logger.error("fail en la firma"+exception.getMessage());
        }
        return false;
    }

    public String refreshToken(JwtDto jwtDto) throws ParseException {
        JWT jwt= JWTParser.parse(jwtDto.getToken());
        JWTClaimsSet claims =jwt.getJWTClaimsSet();
        String nameUser= claims.getSubject();
        List<String> roles = (List<String>) claims.getClaim("roles");
        return Jwts.builder()
                .setSubject(nameUser)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }
}
