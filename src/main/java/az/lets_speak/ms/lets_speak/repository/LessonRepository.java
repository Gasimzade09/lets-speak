package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    //@Modifying
    /*@Query(value = "INSERT INTO lessons (created_date, expiration_date, name, url, student_id, teacher_id) " +
            "VALUES (:crDate, :expDate, :studentName, :url, :studentId, :teacherId)", nativeQuery = true)
    public void setLessonForStudent(@Param("crDate")LocalDate crDate, @Param("expDate")LocalDate expDate,
                                    @Param("studentName")String studentName, @Param("url")String url, @Param("studentId")Integer studentId,
                                    @Param("teacherId")Integer teacherId);*/
}
