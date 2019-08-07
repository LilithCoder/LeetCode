import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//Priority Queue
public class sol_253 {

    class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare (int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalComparator());
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        pqueue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= pqueue.peek()){
                pqueue.remove(pqueue.peek());
            }
            pqueue.add(intervals[i][1]);
        }
        return pqueue.size();
    }
}
