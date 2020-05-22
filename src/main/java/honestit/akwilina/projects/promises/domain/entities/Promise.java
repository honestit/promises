package honestit.akwilina.projects.promises.domain.entities;

import honestit.akwilina.projects.promises.domain.entities.enums.PromiseState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "promises")
@Getter @Setter @ToString(callSuper = true, exclude = {"giver", "receiver"})
public class Promise extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String content;
    @ManyToOne(optional = false)
    @JoinColumn(name = "giver_id")
    private User giver;
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Friend receiver;
    @Column(name = "to_itself")
    private Boolean toItself;
    @Column(name = "given_at")
    private LocalDateTime givenAt;
    @Column(name = "deadline")
    private LocalDateTime deadline;
    @Enumerated(EnumType.STRING)
    private PromiseState state = PromiseState.NEW;

    @OneToMany
    private Set<Friend> friends;
}
