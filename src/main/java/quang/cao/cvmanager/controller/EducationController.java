package quang.cao.cvmanager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quang.cao.cvmanager.consts.ApiPath;
import quang.cao.cvmanager.dto.EducationDto;
import quang.cao.cvmanager.service.EducationService;

import java.util.List;

@RestController
@Slf4j
public class EducationController {

    @Autowired
    private EducationService educationService;


    /**
     * Lấy danh sách tất cả các Education
     * @return
     */
    @GetMapping(value = ApiPath.EDUCATION_GET_ALL)
    public ResponseEntity<List<EducationDto>> getAllEducations() {
        try {
            List<EducationDto> list = educationService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Lỗi khi lấy danh sách Education:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Lấy Education theo ID
     * @param id
     * @return
     */
    @GetMapping(value = ApiPath.EDUCATION_GET_BY_ID)
    public ResponseEntity<EducationDto> getEducationById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            EducationDto education = educationService.findById(id);
            return new ResponseEntity<>(education, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Lỗi khi lấy Education theo ID:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Tạo mới một Education
     * @param request
     * @return
     */
    @PostMapping(value = ApiPath.EDUCATION_CREATE)
    public ResponseEntity<EducationDto> createEducation(@RequestBody EducationDto request) {
        try {
            if (request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            EducationDto createdEducation = educationService.saveEducation(request);
            return new ResponseEntity<>(createdEducation, HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error("Lỗi khi tạo Education:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Cập nhật Education theo ID
     * @param id
     * @param request
     * @return
     */
    @PutMapping(value = ApiPath.EDUCATION_UPDATE_BY_ID)
    public ResponseEntity<EducationDto> updateEducation(@PathVariable Long id, @RequestBody EducationDto request) {
        try {
            if (id == null || request == null) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
            request.setId(id); // Đảm bảo ID trong request khớp với ID trong URL
            EducationDto updatedEducation = educationService.saveEducation(request);
            return new ResponseEntity<>(updatedEducation, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Lỗi khi cập nhật Education:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Xóa Education theo ID
     * @param id
     * @return
     */
    @DeleteMapping(value = ApiPath.EDUCATION_DELETE_BY_ID)
    public ResponseEntity<Void> deleteEducationById(@PathVariable Long id) {
        try {
            if (id == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            educationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception ex) {
            log.error("Lỗi khi xóa Education theo ID:", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

