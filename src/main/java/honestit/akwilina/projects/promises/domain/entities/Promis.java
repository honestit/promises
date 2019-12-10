package honestit.akwilina.projects.promises.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "promises")
@Getter @Setter @ToString(callSuper = true)
public class Promis extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String content;
    @ManyToOne(optional = false)
    @JoinColumn(name = "giver_id")
    private User giver;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;
    @Column(name = "to_itself")
    private Boolean toItself;
    @Column(name = "given_at")
    private LocalDateTime givenAt;
    @Column(name = "deadline")
    private LocalDateTime deadline;
}
