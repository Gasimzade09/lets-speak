package az.lets_speak.ms.lets_speak.security.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationRequest {

    private String username;

    private String password;

}