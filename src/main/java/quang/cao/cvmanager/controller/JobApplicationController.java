package quang.cao.cvmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quang.cao.cvmanager.consts.ApiPath;
import quang.cao.cvmanager.dto.JobApplicationDto;
import quang.cao.cvmanager.service.JobApplicationService;

import java.util.List;

@RestController
@Slf4j
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping(value = ApiPath.JOB_APPLICATION_GET_ALL)
    public ResponseEntity<List<JobApplicationDto>> getAllJobApplications() {
        try {
            List<JobApplicationDto> list = jobApplicationService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting all job applications:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.JOB_APPLICATION_GET_BY_ID)
    public ResponseEntity<JobApplicationDto> getJobApplicationById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            JobApplicationDto jobApplication = jobApplicationService.findById(id);
            return new ResponseEntity<>(jobApplication, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting job application by ID:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = ApiPath.JOB_APPLICATION_CREATE)
    public ResponseEntity<JobApplicationDto> createJobApplication(@RequestBody JobApplicationDto request) {
        try {
            if (request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            JobApplicationDto createdJobApplication = jobApplicationService.saveJobApplication(request);
            return new ResponseEntity<>(createdJobApplication, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Error when creating job application:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = ApiPath.JOB_APPLICATION_UPDATE_BY_ID)
    public ResponseEntity<JobApplicationDto> updateJobApplication(@PathVariable Long id, @RequestBody JobApplicationDto request) {
        try {
            if (id == null || request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            request.setId(id);
            JobApplicationDto updatedJobApplication = jobApplicationService.saveJobApplication(request);
            return new ResponseEntity<>(updatedJobApplication, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when updating job application:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = ApiPath.JOB_APPLICATION_DELETE_BY_ID)
    public ResponseEntity<Void> deleteJobApplicationById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            jobApplicationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            log.error("Error when deleting job application by ID:", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

