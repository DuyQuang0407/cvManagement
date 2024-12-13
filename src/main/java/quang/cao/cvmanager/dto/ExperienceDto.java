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
public class ExperienceDto {
    private Long id;
    private Long cvId;
    private String company;
    private String position;
    private Date startDate;
    private Date endDate;
    private String description;
}
