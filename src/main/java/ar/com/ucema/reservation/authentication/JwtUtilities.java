package ar.com.ucema.reservation.authentication;

import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JwtUtilities {

    private static final String secret = "2b44b0b00fd822d8ce753e54dac3dc4e06c2725f7db930f3b9924468b53194dbccdbe23d7baa5ef5fbc414ca4b2e64700bad60c5a7c45eaba56880985582fba4";
    private static final Long expiration = 3600L;

    private static final Logger logger = LoggerFactory.getLogger(JwtUtilities.class);

    public String generateToken(String username, Long id, String role) {
        return Jwts.builder()
                .setSubject(username) // Establece el subject
                .claim("id", id) //Establece las Claims: información del usuario en el token.
                .setIssuedAt(new Date(System.currentTimeMillis())) //Fecha de emisión del token.
                .setExpiration(Date.from(Instant.now().plus(expiration, ChronoUnit.SECONDS))) //Fecha de expiracion del token.
                .signWith(SignatureAlgorithm.HS256,secret) //Firma el token.
                .compact(); //Crea una cadena JWT con la configuración establecida.
    }

    public String getToken(HttpServletRequest httpServletRequest) {
        String bearerToken = httpServletRequest.getHeader("Authorization"); //Obtiene el contenido del Authorization Header

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) { // Verifica que sea un token JWT
            return bearerToken.substring(7); //Obtiene la cadena del token.
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            // Si puedo obtener las claims entonces el token es valido
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }
}
