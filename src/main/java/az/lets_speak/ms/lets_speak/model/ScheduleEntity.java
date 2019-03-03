package az.lets_speak.ms.lets_speak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "schedules")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    private LocalTime time;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private StudentEntity student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="teacher_id")
    private TeacherEntity teacher;
}