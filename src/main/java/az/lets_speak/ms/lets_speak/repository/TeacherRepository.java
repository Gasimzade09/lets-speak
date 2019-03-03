package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

    @Query(value = "SELECT * FROM teachers t WHERE t.id = " +
            "(SELECT s.teacher_id FROM students s WHERE s.id = ?1)", nativeQuery = true)
    TeacherEntity getTeacherByStudentId(int id);
}
