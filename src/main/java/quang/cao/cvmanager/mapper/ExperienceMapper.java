package quang.cao.cvmanager.mapper;

import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.ExperienceDto;
import quang.cao.cvmanager.entity.Experience;
import quang.cao.cvmanager.mapper.abstracts.AbstractMapper;

@Service
public class ExperienceMapper extends AbstractMapper<Experience, ExperienceDto> {
    public ExperienceMapper() {
        super(Experience.class, ExperienceDto.class);
    }
}
