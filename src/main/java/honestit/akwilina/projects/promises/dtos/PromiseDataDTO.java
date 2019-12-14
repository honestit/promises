package honestit.akwilina.projects.promises.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PromiseDataDTO {

    private Long id;
    private String name;
    private String receiverName;
    private String receiverEmail;
    private LocalDateTime givenAt;
    private LocalDateTime deadline;
}
