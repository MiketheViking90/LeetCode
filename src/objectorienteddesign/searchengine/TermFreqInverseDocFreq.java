package objectorienteddesign.searchengine;

import java.util.HashMap;
import java.util.Map;

public class TermFreqInverseDocFreq {
    private Map<String, Integer> wordToDocumentFreq = new HashMap<>();
    private Map<Integer, Map<String, Integer>> documentToTermFreq = new HashMap<>();

    public double getTfidf() {
        return 0.;
    }
}
