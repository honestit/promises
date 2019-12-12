package honestit.akwilina.projects.promises.domain.repositories;

import honestit.akwilina.projects.promises.domain.entities.Friend;
import honestit.akwilina.projects.promises.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    Friend getOneByOwnerAndName(User user, String friendName);

    boolean existsByOwnerAndName(User user, String name);
}
