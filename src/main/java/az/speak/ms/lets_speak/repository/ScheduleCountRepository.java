package az.speak.ms.lets_speak.repository;

import az.speak.ms.lets_speak.model.ScheduleCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleCountRepository extends JpaRepository<ScheduleCountEntity, Integer> {
    List<ScheduleCountEntity> findAllByIdIsNot(List<Integer> id);

    List<ScheduleCountEntity> findAllByCourseId(Integer courseId);


}
