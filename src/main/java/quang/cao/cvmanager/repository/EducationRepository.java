package quang.cao.cvmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quang.cao.cvmanager.entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
