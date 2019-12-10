package honestit.akwilina.projects.promises.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AccountController {

    @GetMapping
    public String prepareAccountPage() {
        return "user/account";
    }
}
