package honestit.akwilina.projects.promises.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class GivePromiseDTO {

    @NotBlank @Size(min = 5)
    private String name;
    @NotBlank
    private String whom;
    @NotNull @FutureOrPresent @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadlineDate;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime deadlineTime;
}
