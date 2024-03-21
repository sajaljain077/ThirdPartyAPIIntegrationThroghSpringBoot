package dice.com.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
//@Order(1)
public class AuthenticateIntercept extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String clientId = request.getHeader("client_id");
        String clientSecret = request.getHeader("client_secret");
        String authKey = request.getHeader("Authorization");
//        if(clientId==null||!clientId.equalsIgnoreCase("abc") || clientSecret==null||!clientSecret.equalsIgnoreCase("xyz")){
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.setContentType("application/json");
//            response.sendError(401,"unAuthorized");
//            return;
//        }else{
//            filterChain.doFilter(request,response);
//        }
        System.out.println(request.getServletPath());
       if(!request.getServletPath().contains("login")) {
           Claims claims = Jwts.parser().setSigningKey("asdfgh1234").parseClaimsJws(authKey.substring(0)).getBody();
           String emailId = (String) claims.get("emailId");
           if (authKey == null || !emailId.equals("abc@gmail.com")) {
               response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
               response.setContentType("application/json");
               response.sendError(401, "unAuthorized");
               return;
           } else {
               filterChain.doFilter(request, response);
           }
       }else {
           filterChain.doFilter(request, response);
       }
    }
}
