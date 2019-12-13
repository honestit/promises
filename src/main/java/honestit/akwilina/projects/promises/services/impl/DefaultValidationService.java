package honestit.akwilina.projects.promises.services.impl;

import honestit.akwilina.projects.promises.domain.repositories.UserRepository;
import honestit.akwilina.projects.promises.services.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j @RequiredArgsConstructor
public class DefaultValidationService implements ValidationService {

    private final UserRepository userRepository;

    @Override
    public boolean isUniqueEmail(String email) {
        return !userRepository.existsByEmail(email);
    }

    @Override
    public boolean isUniqueUsername(String username) {
        return !userRepository.existsByUsername(username);
    }
}
