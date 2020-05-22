package honestit.akwilina.projects.promises.services.impl;

import honestit.akwilina.projects.promises.domain.entities.Friend;
import honestit.akwilina.projects.promises.domain.entities.Promise;
import honestit.akwilina.projects.promises.domain.entities.User;
import honestit.akwilina.projects.promises.domain.entities.enums.PromiseState;
import honestit.akwilina.projects.promises.domain.repositories.FriendRepository;
import honestit.akwilina.projects.promises.domain.repositories.PromiseRepository;
import honestit.akwilina.projects.promises.domain.repositories.UserRepository;
import honestit.akwilina.projects.promises.dtos.GiveMassPromiseDTO;
import honestit.akwilina.projects.promises.dtos.GivePromiseDTO;
import honestit.akwilina.projects.promises.dtos.PromiseDataDTO;
import honestit.akwilina.projects.promises.services.FriendsService;
import honestit.akwilina.projects.promises.services.UserService;
import honestit.akwilina.projects.promises.utils.bean.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final FriendsService friendsService;
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final PromiseRepository promiseRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void givePromise(GivePromiseDTO givePromiseDTO) {
        User user = userRepository.getByUsername(SecurityUtils.getUsername());
        log.debug("Adding promise for user: {}", user);
        String whom = givePromiseDTO.getWhom();
        createFriendIfNotExists(whom);
        Friend friend = friendRepository.getOneByOwnerAndName(user, whom);
        log.debug("Promise was given to a friend: {}", friend);
        Promise promise = createPromise(givePromiseDTO, user, friend);
        log.debug("Saving promise: {}", promise);
        promiseRepository.save(promise);
        log.debug("Promise saved! {}", promise);
    }

    @Override
    @Transactional
    public void givePromises(GiveMassPromiseDTO giveMassPromiseDTO) {
        User user = userRepository.getByUsername(SecurityUtils.getUsername());
        log.debug("Adding promises for user: {}", user);
        List<Friend> friends = friendRepository.findAllByOwnerAndNameIn(user, giveMassPromiseDTO.getFriends()
                .stream()
                .map(GiveMassPromiseDTO.FriendNameAndDeadline::getName)
                .collect(Collectors.toList()));
        Map<String, Friend> friendsMap = friends.stream().collect(Collectors.toMap(Friend::getName, f -> f));
        log.debug("Saving {} promises", friends.size());
        giveMassPromiseDTO.getFriends()
                .stream()
                .map(friendNameAndDeadline -> {
                    GivePromiseDTO givePromiseDTO = new GivePromiseDTO();
                    givePromiseDTO.setDeadlineDate(friendNameAndDeadline.getDeadlineDate());
                    givePromiseDTO.setName(giveMassPromiseDTO.getWhat());
                    givePromiseDTO.setWhom(friendNameAndDeadline.getName());
                    return givePromiseDTO;
                })
                .map(givePromiseDTO -> createPromise(givePromiseDTO, user, friendsMap.get(givePromiseDTO.getWhom())))
                .forEach(promiseRepository::save);
        log.debug("{} promises saved!", friends.size());
    }

    @Override
    @Transactional
    public List<PromiseDataDTO> getUpcomingPromises() {
        User user = userRepository.getByUsername(SecurityUtils.getUsername());
        List<Promise> upcomingPromises = promiseRepository.findAllByGiverAndStateOrderByDeadlineAscGivenAtAsc(user, PromiseState.NEW);
        ModelMapper modelMapper = new ModelMapper(); // Using own model mapper for default strategy
        return upcomingPromises.stream().map(p -> modelMapper.map(p, PromiseDataDTO.class)).collect(Collectors.toList());
    }

    private Promise createPromise(GivePromiseDTO givePromiseDTO, User user, Friend friend) {
        Promise promise = new Promise();
        promise.setGiver(user);
        promise.setReceiver(friend);
        promise.setName(givePromiseDTO.getName());
        promise.setGivenAt(LocalDateTime.now());
        promise.setState(PromiseState.NEW);
        if (givePromiseDTO.getDeadlineTime() != null) {
            promise.setDeadline(LocalDateTime.of(givePromiseDTO.getDeadlineDate(), givePromiseDTO.getDeadlineTime()));
        } else {
            promise.setDeadline(LocalDateTime.of(givePromiseDTO.getDeadlineDate(), LocalTime.MIDNIGHT));
        }
        return promise;
    }

    private void createFriendIfNotExists(String whom) {
        if (!friendsService.isFriend(whom)) {
            log.debug("{} is not a friend. Adding {} as friend", whom, whom);
            friendsService.addFriend(whom);
            log.debug("{} added as a friend", whom);
        }
    }
}
