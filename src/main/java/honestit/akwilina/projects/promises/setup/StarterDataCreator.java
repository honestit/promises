package honestit.akwilina.projects.promises.setup;

import honestit.akwilina.projects.promises.domain.entities.Role;
import honestit.akwilina.projects.promises.domain.entities.User;
import honestit.akwilina.projects.promises.domain.repositories.RoleRepository;
import honestit.akwilina.projects.promises.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile({"heroku", "dev"})
@Slf4j
@RequiredArgsConstructor
public class StarterDataCreator implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        createRoles();
    }

    private void createRoles() {
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.save(userRole);

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.save(adminRole);
    }

    private void createUsers() {
        User user = new User();
        user.setUsername("user");
        user.setEmail("user@test.mail");
        user.setPassword(passwordEncoder.encode("pass"));
        user.setActive(true);
        user.getRoles().add(roleRepository.getByName("ROLE_USER"));
        userRepository.save(user);
    }
}
