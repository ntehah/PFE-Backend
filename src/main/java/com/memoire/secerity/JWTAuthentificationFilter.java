package com.memoire.secerity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.memoire.entity.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {
   private AuthenticationManager authenticationManager;

    public JWTAuthentificationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    //info sur user authentifer
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {

            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));


        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


// retourner  spring  secirity un objet  de type outhentication  qui contient  oles info
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        List<java.lang.String> roles = new ArrayList<>();
        authResult.getAuthorities().forEach(a->{
            roles.add(a.getAuthority());
        });
        String jwt= JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withArrayClaim("roles",roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis()+SecurityParams.EXPIRATION))
                .sign(Algorithm.HMAC256(SecurityParams.SECRET));
       response.addHeader(SecurityParams.JWT_HEADER_NAME,jwt);
    }



}


