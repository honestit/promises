package honestit.akwilina.projects.promises.controllers;

import honestit.akwilina.projects.promises.dtos.GivePromiseDTO;
import honestit.akwilina.projects.promises.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/promises") @Slf4j
public class GivePromiseController {

    private final UserService userService;

    public GivePromiseController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String processGivePromise(@ModelAttribute("givenPromise") @Valid GivePromiseDTO givePromiseDTO, BindingResult result) {
        log.debug("Promise data: {}", givePromiseDTO);
        if (result.hasErrors()) {
            return "index";
        }
        userService.givePromise(givePromiseDTO);
        log.info("Another promise has been given!");
        return "redirect:/?youPromise";
    }
}
