package az.speak.ms.lets_speak.security.model.dto;

import lombok.Getter;

@Getter
public class JwtAuthenticationResponse {

    private final String token;

    private final String userRole;

    private final Integer privateId;

    public JwtAuthenticationResponse(String token, String userRole, Integer privateId) {
        this.token = token;
        this.userRole = userRole;
        this.privateId = privateId;
    }

}