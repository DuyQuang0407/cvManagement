package quang.cao.cvmanager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.ExperienceDto;
import quang.cao.cvmanager.entity.Experience;
import quang.cao.cvmanager.mapper.ExperienceMapper;
import quang.cao.cvmanager.repository.ExperienceRepository;
import quang.cao.cvmanager.service.ExperienceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    @Autowired
    private ExperienceMapper mapper;

    @Override
    public List<ExperienceDto> findAll() {
        List<Experience> experiences = repository.findAll();
        return (experiences != null && experiences.size() > 0) ?
                experiences.stream()
                        .map(mapper::convertEntityToDTO)
                        .collect(Collectors.toList())
                : new ArrayList<>();
    }

    @Override
    public ExperienceDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::convertEntityToDTO)
                .orElseThrow(() -> new RuntimeException("Experience not found with ID: " + id));
    }

    @Override
    public ExperienceDto saveExperience(ExperienceDto experienceDto) {
        if (experienceDto != null) {
            Experience experience = mapper.convertDTOToEntity(experienceDto);
            return mapper.convertEntityToDTO(repository.save(experience));
        }
        return new ExperienceDto();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
