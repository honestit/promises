package honestit.akwilina.projects.promises.setup;

import honestit.akwilina.projects.promises.domain.entities.Role;
import honestit.akwilina.projects.promises.domain.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Profile({"heroku", "dev"})
@Slf4j
@RequiredArgsConstructor
public class StarterDataCreator implements ApplicationRunner {

    private final RoleRepository roleRepository;

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
}
