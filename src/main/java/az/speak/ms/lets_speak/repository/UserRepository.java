package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.security.model.dto.JwtAuthenticationResponse;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.time.LocalDate;
import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long>{


    UserEntity getByEmail(String email);

    @Query(value = "UPDATE users SET token = null WHERE users.email = ?1", nativeQuery = true)
    void removeTokenByUsername(String username);


    UserEntity findByToken(String token);

    //UserEntity findByToken(String token);

    UserEntity findByPrivateIdAndRole(Integer privateId, String role);
}