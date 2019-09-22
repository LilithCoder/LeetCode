import java.util.HashSet;
import java.util.Set;

public class sol_771_hashtable {
    // when problems comes with two sets with overlapping, then use hashset or hashmap
    // treeset sort elements automatically

    /***
     * HashSet does not allow duplicate elements that means you can not store duplicate values in HashSet.
     * HashMap does not allow duplicate keys however it allows to have duplicate values.
     */
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char j: J.toCharArray()) {
            jewels.add(j);
        }
        int numOfJewels = 0;
        for (char s: S.toCharArray()) {
            if (jewels.contains(s)) {
                numOfJewels++;
            }
        }
        return numOfJewels;
    }
}
