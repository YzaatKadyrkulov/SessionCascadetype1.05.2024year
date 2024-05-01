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
@Table(name = "courses")
@Builder
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_sqe", allocationSize = 1)
    private Long id;
    private String name;
    private int price;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @OneToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE},
            mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.MERGE,
            CascadeType.DETACH,
             },mappedBy = "courses")
    private List<Student> students;

    @OneToMany(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private List<Mentor> mentors;
}
