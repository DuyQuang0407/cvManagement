package quang.cao.cvmanager.service;

import quang.cao.cvmanager.dto.CVDto;

import java.util.List;

public interface CVService {
    CVDto createCV(CVDto cvDto);

    CVDto updateCV(String name, CVDto cvDto);

    CVDto getCVByName(String name);

    List<CVDto> getAllCVs();

    void deleteCV(String name);
}
