package honestit.akwilina.projects.promises.domain.repositories;

import honestit.akwilina.projects.promises.domain.entities.Promise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromiseRepository extends JpaRepository<Promise, Long> {
}
