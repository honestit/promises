package honestit.akwilina.projects.promises.services.impl;

import honestit.akwilina.projects.promises.domain.entities.Friend;
import honestit.akwilina.projects.promises.domain.entities.Promise;
import honestit.akwilina.projects.promises.domain.entities.User;
import honestit.akwilina.projects.promises.domain.repositories.FriendRepository;
import honestit.akwilina.projects.promises.domain.repositories.PromiseRepository;
import honestit.akwilina.projects.promises.domain.repositories.UserRepository;
import honestit.akwilina.projects.promises.dtos.GivenPromiseDTO;
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

@Service @Slf4j
@RequiredArgsConstructor
public class DefaultUserService implements UserService {

    private final FriendsService friendsService;
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final PromiseRepository promiseRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public void givePromise(GivenPromiseDTO givenPromiseDTO) {
        User user = userRepository.getByUsername(SecurityUtils.getUsername());
        log.debug("Adding promise for user: {}", user);
        String whom = givenPromiseDTO.getWhom();
        createFriendIfNotExists(whom);
        Friend friend = friendRepository.getOneByOwnerAndName(user, whom);
        log.debug("Promise was given to a friend: {}", friend);
        Promise promise = createPromise(givenPromiseDTO, user, friend);
        log.debug("Saving promise: {}", promise);
        promiseRepository.save(promise);
        log.debug("Promise saved! {}", promise);
    }

    private Promise createPromise(GivenPromiseDTO givenPromiseDTO, User user, Friend friend) {
        Promise promise = new Promise();
        promise.setGiver(user);
        promise.setReceiver(friend);
        promise.setName(givenPromiseDTO.getName());
        promise.setGivenAt(LocalDateTime.now());
        if (givenPromiseDTO.getDeadlineTime() != null) {
            promise.setDeadline(LocalDateTime.of(givenPromiseDTO.getDeadlineDate(), givenPromiseDTO.getDeadlineTime()));
        }
        else {
            promise.setDeadline(LocalDateTime.of(givenPromiseDTO.getDeadlineDate(), LocalTime.MIDNIGHT));
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
