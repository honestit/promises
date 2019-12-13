package honestit.akwilina.projects.promises.services;

public interface ValidationService {

    boolean isUniqueEmail(String email);

    boolean isUniqueUsername(String username);
}
