package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query(value = "SELECT * " +
            "FROM teachers t " +
            "WHERE t.id = ?1", nativeQuery = true)
    Teacher getTeacherByStudentId(int id);

    @Query(value = "SELECT * " +
            "FROM students s " +
            "WHERE s.teacher_id = ?1", nativeQuery = true)
    List getStudentsByTeacherId(int id);
}
