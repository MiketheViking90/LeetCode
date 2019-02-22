package eighteen.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> pres = new HashSet<>(dict);

        StringBuffer sb = new StringBuffer();
        for (String word : sentence.split(" ")) {
            boolean replaced = false;
            for (int i = 1; i < word.length(); i++) {
                String p = word.substring(0, i);
                if (pres.contains(p)) {
                    sb.append(p + " ");
                    replaced = true;
                    break;
                }
            }
            if (!replaced) {
                sb.append(word + " ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList(new String[]{"rat", "bat", "cat"});
        String sent = "the cattle was rattled by the battery";
        ReplaceWords rw = new ReplaceWords();
        String s = rw.replaceWords(dict, sent);
        System.out.println(s);
    }
}
