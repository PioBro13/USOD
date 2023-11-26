package pl.usod.security.jwt;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.usod.security.sevices.UserDetailsImpl;

import java.security.Key;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class JwtUtils {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(JwtUtils.class);

    @Value("${USOD.app.jwtSecret}")
    private String jwtSecret;

    @Value("${USOD.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.log(Level.parse("Invalid JWT token: {}"), e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.log(Level.parse("JWT token is expired: {}"), e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.log(Level.parse("JWT token is unsupported: {}"), e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.log(Level.parse("JWT claims string is empty: {}"), e.getMessage());
        }

        return false;
    }

}
