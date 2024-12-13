package quang.cao.cvmanager.mapper;

import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.SkillDto;
import quang.cao.cvmanager.entity.Skill;
import quang.cao.cvmanager.mapper.abstracts.AbstractMapper;

@Service
public class SkillMapper extends AbstractMapper<Skill, SkillDto> {
    public SkillMapper() {
        super(Skill.class, SkillDto.class);
    }
}
