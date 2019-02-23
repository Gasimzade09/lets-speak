package az.lets_speak.ms.lets_speak.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonManagedReference
    private Teacher teacher;

    @OneToMany(mappedBy = "group")
    @JsonBackReference
    private Set<Student> students;

    @OneToMany(mappedBy = "group")
    @JsonBackReference
    private Set<Schedule> schedules;
}
