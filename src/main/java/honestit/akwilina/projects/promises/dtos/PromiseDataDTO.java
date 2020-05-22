package honestit.akwilina.projects.promises.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class PromiseDataDTO {

    private Long id;
    private String name;
    private String receiverName;
    private String receiverEmail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime givenAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime deadline;

    public String formattedGivenAt() {
        return givenAt.format(DateTimeFormatter.ofPattern("d MMMM uuuu HH:mm"));
    }

    public String formattedDeadline() {
        return deadline.format(DateTimeFormatter.ofPattern("d MMMM uuuu HH:mm"));
    }

    public boolean isUrgent() {
        return !deadline.toLocalDate().isAfter(LocalDate.now());
    }
}
