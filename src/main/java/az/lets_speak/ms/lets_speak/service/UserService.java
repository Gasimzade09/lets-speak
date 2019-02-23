package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
