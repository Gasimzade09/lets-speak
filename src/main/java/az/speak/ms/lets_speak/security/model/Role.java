package az.speak.ms.lets_speak.security.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ROLE_STUDENT, ROLE_ADMIN, ROLE_TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }

}