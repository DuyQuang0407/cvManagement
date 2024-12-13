package quang.cao.cvmanager.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quang.cao.cvmanager.dto.CVDto;
import quang.cao.cvmanager.entity.CV;
import quang.cao.cvmanager.mapper.CVMapper;
import quang.cao.cvmanager.repository.CVRepository;
import quang.cao.cvmanager.service.CVService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CVServiceImpl implements CVService {

    @Autowired
    private CVRepository repository;

    @Autowired
    private CVMapper mapper;

    @Override
    public CVDto createCV(CVDto cvDto) {
        if (cvDto != null) {
            CV cv = mapper.convertDTOToEntity(cvDto);
            return mapper.convertEntityToDTO(repository.save(cv));
        }
        return new CVDto();
    }

    @Override
    public CVDto updateCV(String name, CVDto cvDto) {
        List<CV> existingCVs = repository.findAllByName(name);
        if (existingCVs == null || existingCVs.isEmpty()) {
            throw new RuntimeException("CV not found with name: " + name);
        }
        CV existingCV = existingCVs.get(0); // Lấy CV đầu tiên tìm thấy

        if (cvDto != null) {
            CV updatedCV = mapper.convertDTOToEntity(cvDto);
            updatedCV.setId(existingCV.getId()); // Giữ nguyên ID
            return mapper.convertEntityToDTO(repository.save(updatedCV));
        }
        return new CVDto();
    }

    @Override
    public CVDto getCVByName(String name) {
        List<CV> cvs = repository.findAllByName(name);
        if (cvs == null || cvs.isEmpty()) {
            throw new RuntimeException("CV not found with name: " + name);
        }
        return mapper.convertEntityToDTO(cvs.get(0)); // Lấy CV đầu tiên tìm thấy
    }

    @Override
    public List<CVDto> getAllCVs() {
        List<CV> cvs = repository.findAll();
        return (cvs != null && !cvs.isEmpty()) ?
                cvs.stream()
                        .map(mapper::convertEntityToDTO)
                        .collect(Collectors.toList())
                : new ArrayList<>();
    }

    @Override
    public void deleteCV(String name) {
        List<CV> cvs = repository.findAllByName(name);
        if (cvs == null || cvs.isEmpty()) {
            throw new RuntimeException("CV not found with name: " + name);
        }
        repository.delete(cvs.get(0)); // Xóa CV đầu tiên tìm thấy
    }
}
