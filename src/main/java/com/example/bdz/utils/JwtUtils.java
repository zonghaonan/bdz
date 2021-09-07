package com.example.bdz.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @Author zhn
 * @Date 2021/9/5 9:37
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "bdz.jwt")
public class JwtUtils {
    private long expire;
    private String secret;
    private String header;
    //生成jwt
    public String generateToken(Map<String,Object> msg){
        Date nowDate=new Date();
        Date expireDate=new Date(nowDate.getTime()+1000*expire);
        return  Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setClaims(msg)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }
    //解析jwt
    public Claims getClaimByToken(String jwt){
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(jwt)
                    .getBody();
        }catch (Exception e){
            return null;
        }
    }
    //jwt是否过期
    public boolean isTokenExpired(Claims claims){
        return claims.getExpiration().before(new Date());
    }
}
