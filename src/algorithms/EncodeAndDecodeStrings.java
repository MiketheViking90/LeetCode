package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        String delim = Character.toString((char) 257);
        StringBuffer enc = new StringBuffer();
        for (String str : strs) {
            enc.append(str);
            enc.append(delim);
        }
        return enc.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        String delim = Character.toString((char) 257);
        String[] strings = s.split(delim);
        return Arrays.asList(strings);
    }
}
