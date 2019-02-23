package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
