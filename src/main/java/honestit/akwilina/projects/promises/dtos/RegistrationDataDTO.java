package honestit.akwilina.projects.promises.dtos;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegistrationDataDTO {

    @NotBlank @Size(min = 3, max = 12)
    private String username;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 4, max = 12)
    private String password;
    @NotBlank @Size(min = 4, max = 12)
    private String rePassword;
    @NotNull @AssertTrue
    private Boolean termsAcceptance;
}
