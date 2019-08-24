import java.util.*;

public class sol_692_1 {

    // wordComparator
    class wordComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            if (a.getValue() != b.getValue()) {
                // descending order
                return a.getValue().compareTo(b.getValue());
            } else {
                //ascending order
                return b.getKey().compareTo(a.getKey());
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCounts = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        for (String word: words) {
            // This method will fetch the corresponding value to this key, if present, and return it.
            // If there is no such mapping, then it returns the defaultValue.
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pqueue = new PriorityQueue<>(new wordComparator());

        for (Map.Entry<String, Integer> wordEntry: wordCounts.entrySet()) {
            pqueue.add(wordEntry);
        }

        for (int i = 0; i < k; i++) {
            resultList.add(pqueue.poll().getKey());
        }
        return resultList;
    }
}
