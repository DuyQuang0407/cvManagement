package quang.cao.cvmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quang.cao.cvmanager.entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}