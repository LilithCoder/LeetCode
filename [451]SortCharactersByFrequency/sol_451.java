package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class sol_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pqueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pqueue.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pqueue.isEmpty()) {
            char currentChar = pqueue.remove();
            for (int i = 0; i < map.get(currentChar); i++) {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
}
