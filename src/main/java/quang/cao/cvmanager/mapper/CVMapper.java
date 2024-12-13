package quang.cao.cvmanager.mapper;

import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.CVDto;
import quang.cao.cvmanager.entity.CV;
import quang.cao.cvmanager.mapper.abstracts.AbstractMapper;

@Service
public class CVMapper extends AbstractMapper<CV, CVDto> {
    public CVMapper() {
        super(CV.class, CVDto.class);
    }
}
