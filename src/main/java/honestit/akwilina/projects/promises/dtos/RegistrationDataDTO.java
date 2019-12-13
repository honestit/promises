package honestit.akwilina.projects.promises.dtos;

import honestit.akwilina.projects.promises.validation.constraints.SamePasswords;
import honestit.akwilina.projects.promises.validation.constraints.UniqueEmail;
import honestit.akwilina.projects.promises.validation.constraints.UniqueUsername;
import honestit.akwilina.projects.promises.validation.groups.BusinessLogic;
import lombok.Data;

import javax.validation.constraints.*;

@Data @SamePasswords
public class RegistrationDataDTO {

    @NotBlank @Size(min = 3, max = 12) @UniqueUsername(groups = BusinessLogic.class)
    private String username;
    @NotBlank @Email @UniqueEmail(groups = BusinessLogic.class)
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
    @NotNull @AssertTrue
    private Boolean termsAcceptance;
}
