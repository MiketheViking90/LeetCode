package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupWords(String[] strings) {
        Map<List<Integer>, List<String>> offsetsToGroup = new HashMap<>();
        for (String s : strings) {
            List<Integer> offset = getOffset(s);
            List<String> curStrings = offsetsToGroup.getOrDefault(offset, new ArrayList<>());
            curStrings.add(s);
            offsetsToGroup.put(offset, curStrings);
        }

        return new ArrayList<>(offsetsToGroup.values());
    }

    private List<Integer> getOffset(String s) {
        if (s.length() == 1) {
            return new ArrayList<>();
        }
        List<Integer> offset = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            int d = s.charAt(i) - s.charAt(i-1);
            offset.add(d);
        }
        return offset;
    }

    public static void main(String[] args) {
        GroupShiftedStrings gss = new GroupShiftedStrings();
        String[] words = {"abc", "bcd", "acef", "xyz", "b", "c"};
        List<List<String>> grps = gss.groupWords(words);
        System.out.println(grps);
    }
}
