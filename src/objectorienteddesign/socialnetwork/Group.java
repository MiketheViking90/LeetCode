package objectorienteddesign.socialnetwork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group extends Account {
    private Set<User> members = new HashSet<>();
    private List<String> wall = new ArrayList<>();

    public void update(User user, String update) {
        if (members.contains(user)) {
            wall.add(update);
        }
    }
}
