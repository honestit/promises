package honestit.akwilina.projects.promises.services.impl;


import honestit.akwilina.projects.promises.domain.entities.Role;
import honestit.akwilina.projects.promises.domain.entities.User;
import honestit.akwilina.projects.promises.domain.repositories.RoleRepository;
import honestit.akwilina.projects.promises.domain.repositories.UserRepository;
import honestit.akwilina.projects.promises.dtos.RegistrationDataDTO;
import honestit.akwilina.projects.promises.services.RegistrationService;
import honestit.akwilina.projects.promises.validation.groups.BusinessLogic;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Transactional @Slf4j @Validated
public class DefaultRegistrationService implements RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final ModelMapper modelMapper;

    public DefaultRegistrationService(PasswordEncoder passwordEncoder, UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @Override @Validated({BusinessLogic.class})
    public void register(@Valid RegistrationDataDTO registrationData) {
        log.debug("Registration data to create user: {}", registrationData);
        User user = modelMapper.map(registrationData, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        user.setActive(Boolean.TRUE);
        String encodedPassword = passwordEncoder.encode(registrationData.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepository.getByName("ROLE_USER");
        user.getRoles().add(roleUser);
        log.debug("User before save: {}", user);
        userRepository.save(user);
        log.debug("User after save: {}", user);
    }
}
