package az.lets_speak.ms.lets_speak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO {
    private String name;

    private String surname;

    private String email;

    private String skype;

    private String phoneNumber;

    private LocalDate birthDate;
}
