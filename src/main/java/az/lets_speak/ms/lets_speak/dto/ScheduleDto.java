package az.lets_speak.ms.lets_speak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    private LocalDate date;

    private LocalTime time;

    private String studentName;

    private String teacherName;
}