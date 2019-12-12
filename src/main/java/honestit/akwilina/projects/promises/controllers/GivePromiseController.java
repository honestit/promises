package honestit.akwilina.projects.promises.controllers;

import honestit.akwilina.projects.promises.dtos.GivenPromiseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/promises") @Slf4j
public class GivePromiseController {

    @PostMapping
    public String processGivePromise(@ModelAttribute("givenPromise") @Valid GivenPromiseDTO givenPromiseDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }
        log.info("Given promise: {}", givenPromiseDTO);
        return "redirect:/";
    }
}
