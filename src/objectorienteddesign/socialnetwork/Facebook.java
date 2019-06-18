package objectorienteddesign.socialnetwork;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Facebook {
    Set<User> users;
    public static final Map<SearchKey, String> NAME_SEARCH = new HashMap<>();

    public static void addNameToSearchIndex(String name) {
        String[] words = name.split("\\s");
        Map<SearchKey, String> searchKeys = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .map(e -> new SearchKey(e.getKey(), e.getValue()))
                .collect(Collectors.toMap(Function.identity(), c -> name));
        NAME_SEARCH.putAll(searchKeys);
    }

    public List<User> search(String query) {
        return new ArrayList<>();
    }
}
