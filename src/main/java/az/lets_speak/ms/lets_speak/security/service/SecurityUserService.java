package az.lets_speak.ms.lets_speak.security.service;

import api.model.User;
import api.repository.UserRepository;
import api.security.model.Role;
import api.security.model.SecurityUser;
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
            String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);

        return buildSecurityUser(user);
    }

    private SecurityUser buildSecurityUser(User user) {
        return SecurityUser.builder()
                .username(user.getUsername())
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