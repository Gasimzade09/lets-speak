package az.speak.ms.lets_speak.dto;

import az.speak.ms.lets_speak.model.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String name;

    private String surname;

    private String email;

    private String skype;

    private String phoneNumber;

    private String password;

    private LocalDate birthDate;

    private String teacherName;

    private Set<TaskEntity> lessons;
}
