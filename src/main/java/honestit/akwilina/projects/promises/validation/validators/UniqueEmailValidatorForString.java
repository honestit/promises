package honestit.akwilina.projects.promises.validation.validators;

import honestit.akwilina.projects.promises.services.ValidationService;
import honestit.akwilina.projects.promises.validation.constraints.UniqueEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@Scope("prototype")
@Slf4j
public class UniqueEmailValidatorForString implements ConstraintValidator<UniqueEmail, String> {

    private ValidationService validationService;

    public void initialize(UniqueEmail constraint) {
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        log.debug("Validating unique email: {}", value);
        boolean unique = validationService.isUniqueEmail(value);
        log.debug("Is email '{}' unique? {}", value, unique);
        return unique;
    }

    @Autowired
    public void setValidationService(ValidationService validationService) {
        this.validationService = validationService;
    }
}
