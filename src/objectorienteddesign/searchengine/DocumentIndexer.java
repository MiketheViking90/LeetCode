package objectorienteddesign.searchengine;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Getter
public class DocumentIndexer {
    private Map<StringCount, List<UUID>> inverseIndex = new HashMap<>();

    public void parseDocument(File file) throws IOException {
        Map<String, Integer> stringCounts = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            line = clean(line);
            String[] words = line.split(" ");
            for (String word : words) {
                if (!word.equals("")) {
                    stringCounts.put(word, stringCounts.getOrDefault(word, 0) + 1);
                }
            }
        }

        UUID id = UUID.randomUUID();
        List<StringCount> scs = stringCounts.entrySet().stream().map(e -> new StringCount(e.getKey(), e.getValue())).collect(Collectors.toList());
        for (StringCount sc : scs) {
            List<UUID> curIds = inverseIndex.getOrDefault(sc, new ArrayList<>());
            curIds.add(id);
            inverseIndex.put(sc, curIds);
        }
    }

    private String clean(String line) {
        return line.replaceAll("[^a-zA-Z ]", "")
                   .toLowerCase();
    }

    public static void main(String[] args) throws IOException {
        String file1 = "/Users/sili/workspace/LeetCode/static/doc1";
        String file2 = "/Users/sili/workspace/LeetCode/static/doc2";
        String file3 = "/Users/sili/workspace/LeetCode/static/doc3";

        DocumentIndexer indexer = new DocumentIndexer();
        indexer.parseDocument(new File(file1));
        indexer.parseDocument(new File(file2));
        indexer.parseDocument(new File(file3));

        System.out.println(indexer.getInverseIndex());
    }
}
