package honestit.akwilina.projects.promises.dtos;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class GivenPromiseDTO {

    @NotBlank @Size(min = 5)
    private String name;
    @NotBlank
    private String whom;
    @NotNull @FutureOrPresent
    private LocalDate deadlineDate;
    private LocalTime deadlineTime;
}
