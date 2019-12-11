package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sol_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // find subset, better using backtracking
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationHelper(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void findCombinationHelper(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                current.add(candidates[i]);
                findCombinationHelper(i + 1, candidates, target - candidates[i], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
