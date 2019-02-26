package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {


}
