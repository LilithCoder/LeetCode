package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sol_957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> cycle = new HashMap<>();
        while (N > 0) {
            int[] cell2 = new int[8];
            cycle.put(Arrays.toString(cells), N);
            N--;
            // the first cell and the last cell will be the default 0
            for (int i = 1; i < 7; i++) {
                cell2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cell2;
            // it will get TLE when N is big, so there need will be a loop.
            if (cycle.containsKey(Arrays.toString(cells))) {
                N %= (cycle.get(Arrays.toString(cells)) - N);
            }
        }
        return cells;
    }
}
