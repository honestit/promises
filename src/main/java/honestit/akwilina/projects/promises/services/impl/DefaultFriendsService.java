package honestit.akwilina.projects.promises.services.impl;

import honestit.akwilina.projects.promises.domain.entities.Friend;
import honestit.akwilina.projects.promises.domain.entities.User;
import honestit.akwilina.projects.promises.domain.repositories.FriendRepository;
import honestit.akwilina.projects.promises.domain.repositories.UserRepository;
import honestit.akwilina.projects.promises.services.FriendsService;
import honestit.akwilina.projects.promises.utils.bean.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Slf4j @RequiredArgsConstructor
public class DefaultFriendsService implements FriendsService {

    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    @Override
    public boolean isFriend(String friendName) {
        User user = userRepository.getByUsername(SecurityUtils.getUsername());
        log.debug("Checking if friend exits: {}", friendName);
        return friendRepository.existsByOwnerAndName(user, friendName);
    }

    @Override
    @Transactional
    public void addFriend(String friendName) {
        log.debug("Adding new friend: {}", friendName);
        User user = userRepository.getByUsername(SecurityUtils.getUsername());
        Friend friend = new Friend();
        friend.setName(friendName);
        friend.setOwner(user);
        friendRepository.save(friend);
        log.debug("Friend {} added to user {}", friend, user);
    }
}
