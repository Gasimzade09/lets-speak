package az.speak.ms.lets_speak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;

    private String courseName;

    private String  tariffName;

    private String studentName;

    private Integer teacherName;
}