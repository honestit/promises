package honestit.akwilina.projects.promises.domain.repositories;

import honestit.akwilina.projects.promises.domain.entities.Promise;
import honestit.akwilina.projects.promises.domain.entities.User;
import honestit.akwilina.projects.promises.domain.entities.enums.PromiseState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PromiseRepository extends JpaRepository<Promise, Long> {

    List<Promise> findAllByGiverAndStateOrderByDeadlineAscGivenAtAsc(User giver, PromiseState state);
}
