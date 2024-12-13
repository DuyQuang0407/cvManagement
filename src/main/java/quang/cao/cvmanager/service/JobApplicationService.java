package quang.cao.cvmanager.service;

import quang.cao.cvmanager.dto.JobApplicationDto;

import java.util.List;

public interface JobApplicationService {
    List<JobApplicationDto> findAll();
    JobApplicationDto findById(Long id);
    JobApplicationDto saveJobApplication(JobApplicationDto jobApplicationDto);
    void deleteById(Long id);
}
