package quang.cao.cvmanager.service;

import quang.cao.cvmanager.dto.ExperienceDto;

import java.util.List;

public interface ExperienceService {
    List<ExperienceDto> findAll();
    ExperienceDto findById(Long id);
    ExperienceDto saveExperience(ExperienceDto experienceDto);
    void deleteById(Long id);
}
