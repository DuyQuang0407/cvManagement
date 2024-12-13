package quang.cao.cvmanager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.EducationDto;
import quang.cao.cvmanager.entity.Education;
import quang.cao.cvmanager.mapper.EducationMapper;
import quang.cao.cvmanager.repository.EducationRepository;
import quang.cao.cvmanager.service.EducationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository repository;

    @Autowired
    private EducationMapper mapper;

    @Override
    public List<EducationDto> findAll() {
        List<Education> educations = repository.findAll();
        return (educations != null && educations.size() > 0) ?
                educations.stream()
                        .map(mapper::convertEntityToDTO)
                        .collect(Collectors.toList())
                : new ArrayList<>();
    }

    @Override
    public EducationDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::convertEntityToDTO)
                .orElseThrow(() -> new RuntimeException("Education not found with ID: " + id));
    }

    @Override
    public EducationDto saveEducation(EducationDto educationDto) {
        if (educationDto != null) {
            Education education = mapper.convertDTOToEntity(educationDto);
            return mapper.convertEntityToDTO(repository.save(education));
        }
        return new EducationDto();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
