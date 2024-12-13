package quang.cao.cvmanager.mapper;


import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.EducationDto;
import quang.cao.cvmanager.entity.Education;
import quang.cao.cvmanager.mapper.abstracts.AbstractMapper;

@Service
public class EducationMapper extends AbstractMapper<Education, EducationDto> {
    public EducationMapper() {
        super(Education.class, EducationDto.class);
    }
}
