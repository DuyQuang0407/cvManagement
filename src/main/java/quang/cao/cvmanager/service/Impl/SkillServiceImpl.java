package quang.cao.cvmanager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.SkillDto;
import quang.cao.cvmanager.entity.Skill;
import quang.cao.cvmanager.mapper.SkillMapper;
import quang.cao.cvmanager.repository.SkillRepository;
import quang.cao.cvmanager.service.SkillService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository repository;

    @Autowired
    private SkillMapper mapper;

    @Override
    public List<SkillDto> findAll() {
        List<Skill> skills = repository.findAll();
        return (skills != null && skills.size() > 0) ?
                skills.stream()
                        .map(mapper::convertEntityToDTO)
                        .collect(Collectors.toList())
                : new ArrayList<>();
    }

    @Override
    public SkillDto findById(Long id) {
        return repository.findById(id)
                .map(mapper::convertEntityToDTO)
                .orElseThrow(() -> new RuntimeException("Skill not found with ID: " + id));
    }

    @Override
    public SkillDto saveSkill(SkillDto skillDto) {
        if (skillDto != null) {
            Skill skill = mapper.convertDTOToEntity(skillDto);
            return mapper.convertEntityToDTO(repository.save(skill));
        }
        return new SkillDto();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}