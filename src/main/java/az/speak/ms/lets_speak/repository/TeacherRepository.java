package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

    @Query(value = "SELECT * FROM teachers t WHERE t.id = " +
            "(SELECT s.teacher_id FROM students s WHERE s.id = ?1)", nativeQuery = true)
    TeacherEntity getTeacherByStudentId(int id);

    @Query(value = "UPDATE teachers SET cv = ?2 WHERE teachers.id = ?1", nativeQuery = true)
    void setCvByTeacherId(Integer id, String cv);

    @Query(value = "SELECT id FROM teachers t WHERE t.email = ?1", nativeQuery = true)
    Integer getIdByEmail(String email);
}
