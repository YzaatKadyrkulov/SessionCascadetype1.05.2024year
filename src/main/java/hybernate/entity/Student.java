package hybernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
@Builder
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
    @SequenceGenerator(name = "student_gen", sequenceName = "student_sqe", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    private String email;
    @Column(name = "year_of_birth")
    private LocalDate yearOfBirth;

    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private List<Course> courses;
}

