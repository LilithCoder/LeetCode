import java.util.HashSet;
import java.util.Set;

public class sol_349_HashSet {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i: nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i: nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (int i: set2) {
            result[index++] = i;
        }
        return result;
    }
}
