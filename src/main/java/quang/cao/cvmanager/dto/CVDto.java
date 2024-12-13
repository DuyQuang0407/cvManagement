package quang.cao.cvmanager.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CVDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String summary;
}
