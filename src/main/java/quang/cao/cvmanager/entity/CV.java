package quang.cao.cvmanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "cv")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "summary")
    private String summary;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(mappedBy = "cv", cascade = CascadeType.ALL)
    private List<JobApplication> jobApplications;
}
