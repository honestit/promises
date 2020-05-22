package honestit.akwilina.projects.promises.controllers;

import honestit.akwilina.projects.promises.dtos.GiveMassPromiseDTO;
import honestit.akwilina.projects.promises.dtos.UserFriendDTO;
import honestit.akwilina.projects.promises.services.FriendsService;
import honestit.akwilina.projects.promises.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/promises/multiply")
public class MassPromiseController {

    private final UserService userService;
    private final FriendsService friendsService;

    public MassPromiseController(UserService userService, FriendsService friendsService) {
        this.userService = userService;
        this.friendsService = friendsService;
    }

    @GetMapping
    public String prepareForm(Model model) {
        model.addAttribute("availableFriends", friendsService.getFriends());
        model.addAttribute("givenPromises", new GiveMassPromiseDTO());
        return "user/give-mass-promise";
    }

    @PostMapping(params = {"addFriend"})
    public String addFriendToForm(@ModelAttribute("givenPromises") GiveMassPromiseDTO givenPromises, Model model) {
        givenPromises.saveFriend();
        model.addAttribute("availableFriends", getAvailableFriends(givenPromises));
        return "user/give-mass-promise";
    }


    @PostMapping(params = {"removeFriend"})
    public String removeFriendFromForm(@ModelAttribute("givenPromises") GiveMassPromiseDTO givenPromises, Model model) {
        givenPromises.removeFriend();
        model.addAttribute("availableFriends", getAvailableFriends(givenPromises));
        return "user/give-mass-promise";
    }

    @PostMapping(params = {"givePromise"})
    public String processForm(@ModelAttribute("givenPromises") @Valid GiveMassPromiseDTO givenPromises,
                              BindingResult result) {
        log.debug("Mass promise data: {}", givenPromises);
        if (result.hasErrors()) {
            return "user/give-mass-promise";
        }
        userService.givePromises(givenPromises);
        log.debug("{} promises have been given!", givenPromises.getFriends().size());
        return "redirect:/?youPromise";
    }

    private List<UserFriendDTO> getAvailableFriends(@ModelAttribute("givenPromises") GiveMassPromiseDTO givenPromises) {
        Set<String> friendsNames = givenPromises.getFriends()
                .stream()
                .map(GiveMassPromiseDTO.FriendNameAndDeadline::getName)
                .collect(Collectors.toSet());
        List<UserFriendDTO> availableFriends = friendsService.getFriends();
        availableFriends.removeIf(friend -> friendsNames.contains(friend.getName()));
        return availableFriends;
    }

}
