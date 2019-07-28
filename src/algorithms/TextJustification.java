package algorithms;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();
        int i = 0;
        List<String> curLine = new ArrayList<>();
        int width = 0;
        while (i < words.length) {
            String word = words[i];
            int wordLen = word.length();

            if (width + wordLen + curLine.size() <= maxWidth) {
                curLine.add(word);
                width += word.length();
            } else {
                String line = justifyWords(curLine, width, maxWidth);
                lines.add(line);
                curLine = new ArrayList<>();
                curLine.add(word);
                width = word.length();
            }
            i++;
        }
        if (!curLine.isEmpty()) {
            lines.add(justifyWords(curLine, width, maxWidth));
        }
        return lines;
    }

    private String justifyWords(List<String> curLine, int width, int maxWidth) {
        int spaces = (maxWidth - width) / Math.max(curLine.size() - 1, 1);
        String line = "";
        for (String word : curLine) {
            line += word;
            for (int i = 0; i < spaces; i++) {
                line += " ";
            }
        }
        return line;
    }
}
