package algorithms;

import org.testng.annotations.Test;

import java.util.List;

public class TextJustificationTest {

    private TextJustification tj = new TextJustification();

    @Test
    public void testFullJustify() {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int w = 20;
        List<String> text = tj.fullJustify(words, w);
        System.out.println(text);
    }

}