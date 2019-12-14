package honestit.akwilina.projects.promises.domain.repositories;

import honestit.akwilina.projects.promises.domain.entities.Promise;
import honestit.akwilina.projects.promises.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PromiseRepository extends JpaRepository<Promise, Long> {

    @Query("SELECT p FROM Promise p WHERE p.giver = ?1 AND p.deadline >= ?2 ORDER BY p.deadline ASC")
    List<Promise> findAllUpcomingPromises(User giver, LocalDateTime after);
}
