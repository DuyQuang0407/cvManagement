package quang.cao.cvmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "proficiency")
    private String proficiency; // Ví dụ: Beginner, Intermediate, Advanced
}
