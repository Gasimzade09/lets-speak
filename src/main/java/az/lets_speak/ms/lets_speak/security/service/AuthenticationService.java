package az.lets_speak.ms.lets_speak.security.service;

import az.lets_speak.ms.lets_speak.security.exceptions.AuthenticationException;
import az.lets_speak.ms.lets_speak.security.model.dto.JwtAuthenticationRequest;
import az.lets_speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import az.lets_speak.ms.lets_speak.security.util.TokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    private final TokenUtils tokenUtils;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            TokenUtils tokenUtils,
            AuthenticationManager authenticationManager) {
        this.tokenUtils = tokenUtils;
        this.authenticationManager = authenticationManager;
    }

    public JwtAuthenticationResponse createAuthenticationToken(
            JwtAuthenticationRequest request) {

        authenticate(request.getUsername(), request.getPassword());

        String token = tokenUtils.generateToken(request.getUsername());

        return new JwtAuthenticationResponse(token);
    }

    public void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials", e);
        }


    }
}
