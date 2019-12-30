package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol_380 {
    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public sol_380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            int index = map.get(val);
            int lastElement = list.get(list.size() - 1);
            map.put(lastElement, index);
            list.set(index, lastElement);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // [0, 1)
        int index = (int) (Math.random() * list.size());
        return list.get(index);
    }
}
