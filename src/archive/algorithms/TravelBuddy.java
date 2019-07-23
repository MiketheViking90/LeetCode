package archive.algorithms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TravelBuddy {
    private static Set<String> wishlist = new HashSet<>();
    static {
        wishlist.add("shanghai");
        wishlist.add("nyc");
        wishlist.add("sf");
    }

    public List<String> getSortedBuddies(List<Friend> friends) {
        List<Friend> friendsWithSim = new ArrayList<>();
        for (Friend friend : friends) {
            double sim = getSimilarity(friend);
            friend.setSimilarity(sim);
        }
        friendsWithSim.sort(Comparator.comparingDouble(Friend::getSimilarity));
        return friendsWithSim.stream().map(Friend::getName).collect(Collectors.toList());
    }

    private double getSimilarity(Friend friend) {
        Set<String> list = new HashSet<>(wishlist);
        list.retainAll(friend.getWishlist());
        int commonCnt = list.size();
        int cnt = friend.wishlist.size();
        return (double) (commonCnt)/cnt;
    }

    @Getter
    @RequiredArgsConstructor
    class Friend {
        private final Set<String> wishlist;
        private final String name;

        @Setter
        private double similarity;
    }
}
