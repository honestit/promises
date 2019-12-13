package honestit.akwilina.projects.promises.validation.validators;

import honestit.akwilina.projects.promises.dtos.RegistrationDataDTO;
import honestit.akwilina.projects.promises.validation.constraints.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SamePasswordsValidatorForRegistrationDataDTO implements ConstraintValidator<SamePasswords, RegistrationDataDTO> {

    public void initialize(SamePasswords constraint) {
    }

    public boolean isValid(RegistrationDataDTO registrationData, ConstraintValidatorContext context) {
        if (registrationData.getPassword() == null || registrationData.getRePassword() == null) {
            return true;
        }
        else {
            boolean valid = registrationData.getPassword().equals(registrationData.getRePassword());
            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("SamePassword.registrationData.rePassword")
                .addPropertyNode("rePassword").addConstraintViolation();
            }
            return valid;
        }
    }
}
