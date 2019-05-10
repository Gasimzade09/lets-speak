package az.speak.ms.lets_speak.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ScheduleCount {
    private Integer id;

    private LocalDate birthDate;

    private String cv;

    private String email;

    private String name;

    private String surname;

    private String phoneNumber;

    private String skype;

    private CourseEntity courseId;

    private Integer count;

}
