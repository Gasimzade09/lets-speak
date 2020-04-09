package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.StudentEntity;
import az.speak.ms.lets_speak.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

    TeacherEntity getByStudents(StudentEntity studentEntity);

    @Query(value = "SELECT id FROM teachers t WHERE t.email = ?1", nativeQuery = true)
    Integer getIdByEmail(String email);
}
