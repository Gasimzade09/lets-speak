package az.lets_speak.ms.lets_speak.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teachers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String email;

    private String skype;

    private String phoneNumber;

    private String password;

    private LocalDate birthDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private Set<Student> students;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private Set<Lesson> lessons;

}
