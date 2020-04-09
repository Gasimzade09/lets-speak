package az.speak.ms.lets_speak.service;

<<<<<<< HEAD
=======
import az.speak.ms.lets_speak.dto.UserDto;
import az.speak.ms.lets_speak.mappers.UserMapper;
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setTokenByUsername(String username, String token) {
        UserEntity userEntity = userRepository.getByEmail(username);
        userEntity.setToken(token);
        userRepository.save(userEntity);
    }

    public void deleteToken(String username) {
        UserEntity userEntity = userRepository.getByEmail(username);
        userEntity.setToken(null);
        userRepository.save(userEntity);
<<<<<<< HEAD
=======
    }

    public UserDto getUserById(Integer id, String role) {
        return UserMapper.userEntityToUserDto(userRepository.findByPrivateIdAndRole(id, role));
    }

    public List<UserDto> getlAll() {
        return UserMapper.entityListToDtoList((List<UserEntity>) userRepository.findAll());
>>>>>>> 544e5c54ddb5e164d8513dbf32ce9bdea74234e5
    }
}