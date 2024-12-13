package quang.cao.cvmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import quang.cao.cvmanager.consts.ApiPath;
import quang.cao.cvmanager.dto.CVDto;
import quang.cao.cvmanager.service.CVService;

import java.util.List;

@RestController
@Slf4j
public class CVController {

    @Autowired
    private CVService cvService;

    @GetMapping(value = ApiPath.PING)
    public String ping() {
        return "Ping!!!!!!!!";
    }

    /**
     * Get all CVs
     * @return
     */
    @GetMapping(value = ApiPath.CV_GET_ALL)
    public ResponseEntity<List<CVDto>> getAllCVs() {
        try {
            List<CVDto> list = cvService.getAllCVs();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting all CVs:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get CV by name
     * @param request
     * @return
     */
    @PostMapping(value = ApiPath.CV_FIND_BY_NAME)
    public ResponseEntity<CVDto> getCVByName(@RequestBody CVDto request) {
        try {
            if (null == request || null == request.getName()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            CVDto cv = cvService.getCVByName(request.getName());
            return new ResponseEntity<>(cv, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when getting CV by name:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Create a CV
     * @param request
     * @return
     */
    @PostMapping(value = ApiPath.CV_CREATE)
    public ResponseEntity<CVDto> createCV(@RequestBody CVDto request) {
        try {
            if (null == request) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            CVDto createdCV = cvService.createCV(request);
            if (createdCV == null || createdCV.getId() == null) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(createdCV, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when creating CV:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update a CV by name
     * @param request
     * @return
     */
    @PostMapping(value = ApiPath.CV_UPDATE_BY_NAME)
    public ResponseEntity<CVDto> updateCVByName(@RequestBody CVDto request) {
        try {
            if (null == request || null == request.getName()) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            CVDto updatedCV = cvService.updateCV(request.getName(), request);
            return new ResponseEntity<>(updatedCV, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when updating CV:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete a CV by name
     * @param request
     * @return
     */
    @PostMapping(value = ApiPath.CV_DELETE_BY_NAME)
    public ResponseEntity<Void> deleteCVByName(@RequestBody CVDto request) {
        try {
            if (null == request || null == request.getName()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            cvService.deleteCV(request.getName());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            log.error("Error when deleting CV:", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

