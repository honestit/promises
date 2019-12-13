package honestit.akwilina.projects.promises.controllers;

import honestit.akwilina.projects.promises.dtos.RegistrationDataDTO;
import honestit.akwilina.projects.promises.services.RegistrationService;
import honestit.akwilina.projects.promises.validation.constraints.UniqueEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/register") @Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "register/form";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("registrationData") @Valid RegistrationDataDTO registrationData, BindingResult results) {
        if (results.hasErrors()) {
            return "register/form";
        }
        try {
            registrationService.register(registrationData);
        } catch (ConstraintViolationException cve) {
            log.warn("Business constraints were violated for {}", registrationData);
            for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
                log.warn("Violation: {}", violation);
                String field = null;
                for (Path.Node node : violation.getPropertyPath()) {
                    field = node.getName();
                }
//                Path field = violation.getPropertyPath();
                results.rejectValue(field,
                        violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName()
                + ".registrationData." + field);
            }
            return "register/form";
        }
        return "redirect:/";
    }

}
