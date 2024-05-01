package hybernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentors")
@Builder
@ToString
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mentor_gen")
    @SequenceGenerator(name = "mentor_gen", sequenceName = "mentor_sqe", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    @Column(name =  "published_date")
    private LocalDate publishedDate;
    @Column(name = "video_link")
    private String videoLink;
    @Column(name = "is_presentetion")
    private String isPresentetion;


}
