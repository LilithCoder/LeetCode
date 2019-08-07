import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class sol_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, new intervalsComparator());

        List<int[]> resultMerge = new ArrayList<>();
        int[] previousInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];

            if (currentInterval[0] <= previousInterval[1]) {
                previousInterval[1] = Math.max(currentInterval[1], previousInterval[1]);
                if (i == intervals.length - 1) {
                    resultMerge.add(previousInterval);
                }
            } else {
                resultMerge.add(previousInterval);

                previousInterval = currentInterval;
                if (i == intervals.length - 1) {
                    resultMerge.add(previousInterval);
                }

            }
        }
        int[][] result = new int[resultMerge.size()][2];
        for (int i = 0; i < resultMerge.size(); i++) {
                result[i] = resultMerge.get(i);
        }
        return result;
    }

    class intervalsComparator implements Comparator<int []> {
        @Override
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }
}
