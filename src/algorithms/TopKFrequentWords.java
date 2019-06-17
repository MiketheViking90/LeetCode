package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            int n = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, n+1);
        }

        PriorityQueue<WordCount> pq = new PriorityQueue<>(k);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            WordCount wc = new WordCount(entry.getKey(), entry.getValue());
            if (pq.size() < k) {
                pq.offer(wc);
            } else {
                WordCount peak = pq.peek();
                if (wc.compareTo(peak) > 0) {
                    pq.poll();
                    pq.offer(wc);
                }
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        Collections.reverse(res);
        return res;
    }

    class WordCount implements Comparable<WordCount>{
        String word;
        int count;

        public WordCount(String word, Integer count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount o) {
            int countCompare = Integer.compare(o.count, this.count);
            if (countCompare != 0) {
                return -countCompare;
            } else {
                return -this.word.compareTo(o.word);
            }
        }
    }

    public static void main(String[] args) {
        TopKFrequentWords tp = new TopKFrequentWords();
        String[] words = {"b", "b", "b", "c", "c", "d", "e", "e", "a", "a", "a"};
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(tp.topKFrequent(words1, 2));
    }
}
