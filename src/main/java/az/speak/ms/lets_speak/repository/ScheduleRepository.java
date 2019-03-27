package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {

    @Query(value = "SELECT * FROM schedules s " +
            "WHERE s.student_id = ?1", nativeQuery = true)
    List<ScheduleEntity> getScheduleEntitiesByStudent(int id);

    @Query(value = "SELECT teacher_id FROM schedules s WHERE s.date != ?1 OR s.time !=?2", nativeQuery = true)
    List<Integer> getFreeTeachers(LocalDate date, LocalTime time);

    @Query(value = "SELECT * FROM schedules s WHERE s.teacher_id = ?1", nativeQuery = true)
    List<ScheduleEntity> getScheduleEntitiesByTeacher(Integer id);
}
