package quang.cao.cvmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quang.cao.cvmanager.entity.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
