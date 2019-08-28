import java.util.PriorityQueue;

public class sol_973 {

    public int[][] kClosest(int[][] points, int K) {

        // make sure there are always K closet points in the maxHeap
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1] - (a[0] * a[0] + a[1] * a[1])));
        for (int[] point: points) {
            pqueue.add(point);
            if (pqueue.size() > K) {
                pqueue.remove();
            }
        }
        while (K-- > 0){
            res[K] = pqueue.remove();
        }
        return res;
    }
}
