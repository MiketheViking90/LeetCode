package objectorienteddesign.socialnetwork;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@RequiredArgsConstructor
public class Page extends Account {
    private String subject;
    private List<String> pendingUpdates = new ArrayList<>();
    private Set<User> bannedUsers = new HashSet<>();
    private User admin;

    public void postPendingUpdate(User user, String update) {
        if (!bannedUsers.contains(user)) {
            pendingUpdates.add(update);
        }
    }
}
