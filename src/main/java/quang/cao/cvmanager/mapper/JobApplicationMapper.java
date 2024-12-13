package quang.cao.cvmanager.mapper;

import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.JobApplicationDto;
import quang.cao.cvmanager.entity.JobApplication;
import quang.cao.cvmanager.mapper.abstracts.AbstractMapper;

@Service
public class JobApplicationMapper extends AbstractMapper<JobApplication, JobApplicationDto> {
    public JobApplicationMapper() {
        super(JobApplication.class, JobApplicationDto.class);
    }
}
