package honestit.akwilina.projects.promises.validation.validators;

import honestit.akwilina.projects.promises.services.ValidationService;
import honestit.akwilina.projects.promises.validation.constraints.UniqueUsername;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class UniqueUsernameValidatorForString implements ConstraintValidator<UniqueUsername, String> {

    private final ValidationService validationService;

    public void initialize(UniqueUsername constraint) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Validating unique username: {}", value);
        boolean unique = validationService.isUniqueUsername(value);
        log.debug("Is username '{}' unique? {}", value, unique);
        return unique;
    }
}
