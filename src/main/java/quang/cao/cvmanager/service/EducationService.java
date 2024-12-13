package quang.cao.cvmanager.service;

import quang.cao.cvmanager.dto.EducationDto;

import java.util.List;

public interface EducationService {
    List<EducationDto> findAll();
    EducationDto findById(Long id);
    EducationDto saveEducation(EducationDto educationDto);
    void deleteById(Long id);
}
