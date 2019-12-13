package honestit.akwilina.projects.promises.validation.constraints;

import honestit.akwilina.projects.promises.validation.validators.SamePasswordsValidatorForRegistrationDataDTO;
import honestit.akwilina.projects.promises.validation.validators.UniqueEmailValidatorForString;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = SamePasswordsValidatorForRegistrationDataDTO.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SamePasswords {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
