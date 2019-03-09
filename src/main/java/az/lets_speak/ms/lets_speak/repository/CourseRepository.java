package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.CourseEntity;
import az.lets_speak.ms.lets_speak.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
}
