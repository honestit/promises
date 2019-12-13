package honestit.akwilina.projects.promises.services;

import honestit.akwilina.projects.promises.dtos.RegistrationDataDTO;

import javax.validation.Valid;

public interface RegistrationService {

    void register(@Valid RegistrationDataDTO registrationData);
}
