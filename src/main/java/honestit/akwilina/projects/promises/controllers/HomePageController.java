package honestit.akwilina.projects.promises.controllers;

import honestit.akwilina.projects.promises.dtos.GivePromiseDTO;
import honestit.akwilina.projects.promises.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/") @RequiredArgsConstructor
public class HomePageController {

    private final UserService userService;

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("upcomingPromises", userService.getUpcomingPromises());
        model.addAttribute("givenPromise", new GivePromiseDTO());
        return "index";
    }
}
