package dice.com.Service;

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
@Order(1)
public class AuthenticateIntercept extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String clientId = request.getHeader("client_id");
        String clientSecret = request.getHeader("client_secret");
        if(clientId==null||!clientId.equalsIgnoreCase("abc") || clientSecret==null||!clientSecret.equalsIgnoreCase("xyz")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.sendError(401,"unAuthorized");
            return;
        }else{
            filterChain.doFilter(request,response);
        }
    }
}
