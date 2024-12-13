package quang.cao.cvmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quang.cao.cvmanager.consts.ApiPath;
import quang.cao.cvmanager.dto.ExperienceDto;
import quang.cao.cvmanager.service.ExperienceService;

import java.util.List;

@RestController
@Slf4j
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping(value = ApiPath.EXPERIENCE_GET_ALL)
    public ResponseEntity<List<ExperienceDto>> getAllExperiences() {
        try {
            List<ExperienceDto> list = experienceService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting all experiences:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.EXPERIENCE_GET_BY_ID)
    public ResponseEntity<ExperienceDto> getExperienceById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            ExperienceDto experience = experienceService.findById(id);
            return new ResponseEntity<>(experience, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting experience by ID:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.EXPERIENCE_CREATE)
    public ResponseEntity<ExperienceDto> createExperience(@RequestBody ExperienceDto request) {
        try {
            if (request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            ExperienceDto createdExperience = experienceService.saveExperience(request);
            return new ResponseEntity<>(createdExperience, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error when creating experience:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.EXPERIENCE_UPDATE_BY_ID)
    public ResponseEntity<ExperienceDto> updateExperience(@PathVariable Long id, @RequestBody ExperienceDto request) {
        try {
            if (id == null || request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            request.setId(id);
            ExperienceDto updatedExperience = experienceService.saveExperience(request);
            return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when updating experience:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.EXPERIENCE_DELETE_BY_ID)
    public ResponseEntity<Void> deleteExperienceById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            experienceService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            log.error("Error when deleting experience by ID:", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

