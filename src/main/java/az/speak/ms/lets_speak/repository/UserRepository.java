package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.email = ?1", nativeQuery = true)
    UserEntity getByEmail(String email);
}
