import java.util.HashSet;
import java.util.Set;

public class sol_202_hashset {
    public boolean isHappy(int n) {
        Set<Integer> sumSet = new HashSet<>();
        while(n != 1) {
            int sum = 0;
            int current = n;
            while (current != 0) {
                sum += (current % 10) * (current % 10);
                current /= 10;
            }
            if (sumSet.contains(sum)) {
                return false;
            }
            sumSet.add(sum);
            n = sum;
        }
        return true;
    }
}
