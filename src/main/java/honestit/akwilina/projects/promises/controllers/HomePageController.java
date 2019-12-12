package honestit.akwilina.projects.promises.controllers;

import honestit.akwilina.projects.promises.dtos.GivenPromiseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("givenPromise", new GivenPromiseDTO());
        return "index";
    }
}
