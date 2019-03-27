package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    UserEntity getByEmail(String email);

    @Query(value = "UPDATE users SET token = ?1 WHERE users.email = ?2", nativeQuery = true)
    void setTokenByUsername(String token, String username);

    @Query(value = "UPDATE users SET token = null WHERE users.email = ?1", nativeQuery = true)
    void removeTokenByUsername(String username);

    @Query(value = "SELECT * FROM users u WHERE u.token = ?1", nativeQuery = true)
    UserEntity getByToken(String token);

}