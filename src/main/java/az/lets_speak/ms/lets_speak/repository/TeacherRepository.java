package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = "SELECT * FROM teachers t WHERE t.id = " +
            "(SELECT s.teacher_id FROM students s WHERE s.id = ?1)", nativeQuery = true)
    Teacher getTeacherByStudentId(int id);
}
