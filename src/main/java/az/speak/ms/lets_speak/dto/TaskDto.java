package az.speak.ms.lets_speak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String name;

    private String url;

    private LocalDate createdDate;

    private LocalDate expirationDate;

    private String teacherName;
}
