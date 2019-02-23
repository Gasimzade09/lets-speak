package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
