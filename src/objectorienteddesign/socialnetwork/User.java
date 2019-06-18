package objectorienteddesign.socialnetwork;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@ToString
public class User extends Account {
    private final String id;
    private final String name;
    private final String email;

    private final Set<User> friends = new HashSet<>();
    private final Set<User> pendingFriendRequests = new HashSet<>();

    private final List<String> timeline = new ArrayList<>();

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;

        Facebook.addNameToSearchIndex(name);
    }

    public void post(String update) {
        for (User user : followers) {
            user.receiveUpdate(update);
        }
        timeline.add(update);
    }

    public void receiveUpdate(String update) {
        timeline.add(update);
    }

    public void addFriend(User user) {
        user.addPendingFriendRequest(this);
    }

    public void followPage(Account account) {
        account.acceptFollower(this);
    }

    public void addPendingFriendRequest(User user) {
        this.pendingFriendRequests.add(user);
    }

    public void acceptFriendRequests() {
        for (User user : pendingFriendRequests) {
            friends.add(user);
            followers.add(user);
            pendingFriendRequests.remove(user);
        }
    }

    public void unfollow(Account account) {
        account.getFollowers().remove(this);
    }
}
