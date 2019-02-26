package az.lets_speak.ms.lets_speak.repository;

import az.lets_speak.ms.lets_speak.model.Student;
import az.lets_speak.ms.lets_speak.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT t.name, t.surname, t.email, t.birth_date, t.phone_number, t.skype " +
            "FROM teachers t LEFT JOIN students s " +
            "ON t.id = s.teacher_id " +
            "WHERE s.id = ?1", nativeQuery = true)
    Teacher getTeacherByStudentId(int id);

}
