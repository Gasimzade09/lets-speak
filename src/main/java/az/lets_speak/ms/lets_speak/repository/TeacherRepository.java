package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
