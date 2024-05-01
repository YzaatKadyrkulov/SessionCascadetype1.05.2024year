package hybernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lessons")
@Builder
@ToString
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "mentor_sqe", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    @Column(name = "published_date")
    private LocalDate publishedDate;
    @Column(name = "video_link")
    private String videoLink;
    @Column(name = "is_presentation")
    private String isPresentation;

    @ManyToOne(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private Course course;

    @OneToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    private Task task;


}