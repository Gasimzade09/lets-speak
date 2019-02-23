package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
