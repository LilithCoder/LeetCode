import java.util.ArrayList;
import java.util.List;

public class sol_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        // corner case
        if (S == null || S.length() == 0) {
            return res;
        }
        int[] lastIndexs = new int[26];
        // store the last index of all letters
        for (int i = 0; i < S.length(); i++) {
            lastIndexs[S.charAt(i) - 'a'] = i;
        }
        int lastIndexOfPartition = 0;
        int beginOfPartition = 0;
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfPartition = Math.max(lastIndexOfPartition, lastIndexs[S.charAt(i) - 'a']);
            if (lastIndexOfPartition == i) {
                res.add(lastIndexOfPartition - beginOfPartition + 1);
                // one partition has been found
                beginOfPartition = lastIndexOfPartition + 1;
            }
        }
        return res;
    }
}
