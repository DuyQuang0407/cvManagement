package quang.cao.cvmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quang.cao.cvmanager.consts.ApiPath;
import quang.cao.cvmanager.dto.SkillDto;
import quang.cao.cvmanager.service.SkillService;

import java.util.List;

@RestController
@Slf4j
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping(value = ApiPath.SKILL_GET_ALL)
    public ResponseEntity<List<SkillDto>> getAllSkills() {
        try {
            List<SkillDto> list = skillService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting all skills:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.SKILL_GET_BY_ID)
    public ResponseEntity<SkillDto> getSkillById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            SkillDto skill = skillService.findById(id);
            return new ResponseEntity<>(skill, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting skill by ID:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.SKILL_CREATE)
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto request) {
        try {
            if (request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            SkillDto createdSkill = skillService.saveSkill(request);
            return new ResponseEntity<>(createdSkill, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error when creating skill:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.SKILL_UPDATE_BY_ID)
    public ResponseEntity<SkillDto> updateSkill(@PathVariable Long id, @RequestBody SkillDto request) {
        try {
            if (id == null || request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            request.setId(id);
            SkillDto updatedSkill = skillService.saveSkill(request);
            return new ResponseEntity<>(updatedSkill, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when updating skill:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.SKILL_DELETE_BY_ID)
    public ResponseEntity<Void> deleteSkillById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            skillService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            log.error("Error when deleting skill by ID:", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

