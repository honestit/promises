package honestit.akwilina.projects.promises.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter @Setter @ToString @EqualsAndHashCode(of = "id")
public class Role {

    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
}
