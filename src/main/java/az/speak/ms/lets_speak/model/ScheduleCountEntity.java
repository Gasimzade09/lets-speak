package az.speak.ms.lets_speak.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "schedule_count")
public class ScheduleCountEntity implements Comparable<ScheduleCountEntity>{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "birth_date")
    private String birthDate;

    private String cv;

    private String email;

    private String name;

    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String skype;

    @Column(name = "course_id")
    private Integer courseId;

    private Integer count;

    @Override
    public int compareTo(ScheduleCountEntity o) {
        return o.getCount() - this.getCount();
    }
}
