package honestit.akwilina.projects.promises.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
@Getter @Setter @ToString(callSuper = true)
public class Friend extends BaseEntity {

    @Column(nullable = false)
    private String name;
    private String email;
    @ManyToOne(optional = true)
    private User account;
    @ManyToOne(optional = true)
    private User owner;
}
