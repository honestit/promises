package honestit.akwilina.projects.promises.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "friends")
@Getter @Setter @ToString(callSuper = true, exclude = {"account", "owner"})
public class Friend extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private User account;
    @ManyToOne(optional = true)
    @JoinColumn(name = "owner_id")
    private User owner;
}
