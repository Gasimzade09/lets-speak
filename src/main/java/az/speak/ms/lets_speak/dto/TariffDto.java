package az.speak.ms.lets_speak.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffDto {
    private Integer id;

    private String name;

    private String countType;

    private Integer duration;

    private Integer timesAWeek;

    private Integer count;

    private BigDecimal price;
}
