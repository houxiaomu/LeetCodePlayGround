package houxiaomu.leetcodeplayground.insert_delete_getrandom_o1;

import java.util.*;

/**
 * Created by Simon on 2017/1/1.
 */
public class RandomizedSet {
    List<Integer> array;
    Map<Integer, Integer> map;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        array = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        array.add(val);
        map.put(val, array.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.remove(val);
        int lastVal = array.get(array.size() - 1);
        array.set(index, lastVal);
        map.put(lastVal, index);
        array.remove(array.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }
}
