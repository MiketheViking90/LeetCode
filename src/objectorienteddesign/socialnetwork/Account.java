package objectorienteddesign.socialnetwork;

import java.util.HashSet;
import java.util.Set;

public abstract class Account {
    protected final Set<User> followers = new HashSet<>();

    public Set<User> getFollowers() {
        return this.followers;
    }

    public void post(String update) {
        for (User follower : followers) {
            follower.receiveUpdate(update);
        }
    }

    public void acceptFollower(User user) {
        followers.add(user);
    }

}
