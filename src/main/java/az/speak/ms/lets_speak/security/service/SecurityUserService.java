package az.speak.ms.lets_speak.security.service;

import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.repository.UserRepository;
import az.speak.ms.lets_speak.security.model.Role;
import az.speak.ms.lets_speak.security.model.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SecurityUserService
        implements UserDetailsService {

    private final UserRepository repository;

    public SecurityUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(
            String email) throws UsernameNotFoundException {

        UserEntity user = repository.getByEmail(email);

        return buildSecurityUser(user);
    }

    private SecurityUser buildSecurityUser(UserEntity user) {
        return SecurityUser.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.singletonList(toSecurityRole(user.getRole())))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true).build();
    }

    private Role toSecurityRole(String role) {
        Role enumRole = null;
        try {
            enumRole = enumRole.valueOf(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return enumRole;

    }


}