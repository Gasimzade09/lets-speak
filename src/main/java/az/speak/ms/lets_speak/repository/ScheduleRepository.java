package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {

    @Query(value = "SELECT * FROM schedules " +
            "WHERE student_id = ?1", nativeQuery = true)
    List<ScheduleEntity> getScheduleEntitiesByStudent(int id);

}
