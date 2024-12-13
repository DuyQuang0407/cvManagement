package quang.cao.cvmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {
    private Long id;
    private Long cvId;
    private String institution;
    private String degree;
    private Date startDate;
    private Date endDate;
    private String description;
}
