package honestit.akwilina.projects.promises.services;

import honestit.akwilina.projects.promises.dtos.GivePromiseDTO;
import honestit.akwilina.projects.promises.dtos.PromiseDataDTO;

import java.util.List;

public interface UserService {

    void givePromise(GivePromiseDTO givePromiseDTO);

    List<PromiseDataDTO> getUpcomingPromises();
}
