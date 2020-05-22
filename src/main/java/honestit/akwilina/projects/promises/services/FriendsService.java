package honestit.akwilina.projects.promises.services;

import honestit.akwilina.projects.promises.dtos.UserFriendDTO;

import java.util.List;

public interface FriendsService {

    boolean isFriend(String friendName);

    void addFriend(String whom);

    List<UserFriendDTO> getFriends();
}
