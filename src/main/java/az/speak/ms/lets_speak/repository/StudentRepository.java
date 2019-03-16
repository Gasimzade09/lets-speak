package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    @Query(value = "SELECT * " +
            "FROM students s " +
            "WHERE s.teacher_id = ?1", nativeQuery = true)
    List<StudentEntity> getStudentsByTeacherId(int id);

    @Query(value = "SELECT id " +
            "FROM students s " +
            "WHERE s.email = ?1", nativeQuery = true)
    Integer getIdByEmail(String email);

    @Query(value = "UPDATE students SET rank = ?1 WHERE students.id = ?2", nativeQuery = true)
    void setRank(double rank, int id);


}
