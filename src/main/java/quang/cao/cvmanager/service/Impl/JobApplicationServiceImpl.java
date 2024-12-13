package quang.cao.cvmanager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.JobApplicationDto;
import quang.cao.cvmanager.entity.JobApplication;
import quang.cao.cvmanager.mapper.JobApplicationMapper;
import quang.cao.cvmanager.repository.JobApplicationRepository;
import quang.cao.cvmanager.service.JobApplicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository repository;

    @Autowired
    private JobApplicationMapper mapper;

    @Override
    public List<JobApplicationDto> findAll() {
        List<JobApplication> jobApplications = repository.findAll();
        return (jobApplications != null && jobApplications.size() > 0) ?
                jobApplications.stream()
                        .map(mapper::convertEntityToDTO)
                        .collect(Collectors.toList())
                : new ArrayList<>();
    }

    @Override
    public JobApplicationDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::convertEntityToDTO)
                .orElseThrow(() -> new RuntimeException("JobApplication not found with ID: " + id));
    }

    @Override
    public JobApplicationDto saveJobApplication(JobApplicationDto jobApplicationDto) {
        if (jobApplicationDto != null) {
            JobApplication jobApplication = mapper.convertDTOToEntity(jobApplicationDto);
            return mapper.convertEntityToDTO(repository.save(jobApplication));
        }
        return new JobApplicationDto();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
