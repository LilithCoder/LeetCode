import java.util.HashMap;
import java.util.Map;

// Use hashtable lookup to increases time complexity.

public class Two_Sum_1 {

    // Sol-1: Two-pass Hash Table
    public int[] twoSum(int[] nums, int target) {

        // create a hashmap with all array elements provided O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        // loop through all hashmap looking for the complement elements,
        // since lookup method(map.containsKey(complement))in hash table only takes O(1),
        // So for loop takes O(n)
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && complement != nums[i]){
                return new int[]{i, map.get(complement)};
            }
        }
        //This exception indicates that a method is called with incorrect input arguments.
        throw new IllegalArgumentException("No two sum solution");
    }
}
