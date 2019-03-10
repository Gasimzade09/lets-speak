package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    //@Modifying
    /*@Query(value = "INSERT INTO lessons (created_date, expiration_date, name, url, student_id, teacher_id) " +
            "VALUES (:crDate, :expDate, :studentName, :url, :studentId, :teacherId)", nativeQuery = true)
    public void setLessonForStudent(@Param("crDate")LocalDate crDate, @Param("expDate")LocalDate expDate,
                                    @Param("studentName")String studentName, @Param("url")String url, @Param("studentId")Integer studentId,
                                    @Param("teacherId")Integer teacherId);*/

    @Query(value = "SELECT * FROM tasks t WHERE t.student_id = ?1", nativeQuery = true)
    List<TaskEntity> getTaskEntitiesByStudentId( int id);
}
