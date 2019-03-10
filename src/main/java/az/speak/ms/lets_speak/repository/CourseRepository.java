package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
