package quang.cao.cvmanager.service;

import quang.cao.cvmanager.dto.SkillDto;

import java.util.List;

public interface SkillService {
    List<SkillDto> findAll();
    SkillDto findById(Long id);
    SkillDto saveSkill(SkillDto skillDto);
    void deleteById(Long id);
}
