package hybernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
@Builder
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_gen")
    @SequenceGenerator(name = "task_gen", sequenceName = "task_sqe", allocationSize = 1)
    private Long id;
    private String title;
    private LocalDate deadline;

    @OneToOne(cascade = {CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.DETACH},
            mappedBy = "task")
    private Lesson lesson;
}
