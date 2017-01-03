package houxiaomu.leetcodeplayground.all_oone_data_structure;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Simon on 2016/12/26.
 */
public class Solution extends BaseSolution {
    @Override
    public boolean runCustomizedTestCases() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("b");
        allOne.inc("b");

        allOne.dec("c");
        allOne.dec("b");
        allOne.dec("b");
        allOne.dec("a");
        return true;
    }

    class Row {
        int val;
        int size;
        Row next, prev;
    }


    public class AllOne {
        Map<String, Row> rowMap = new HashMap<>();
        Row max, min;

        /**
         * Initialize your data structure here.
         */
        public AllOne() {

        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (rowMap.containsKey(key)) {
                Row row = rowMap.get(key);
                removeKey(key, row.val);
                addKey(row, key, row.val + 1);
            } else {
                addKey(null, key, 1);
            }
        }

        private void addKey(Row prevRow, String key, int val) {

        }

        private void removeKey(String key, int val) {
        }


        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {

        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            return null;
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            return null;
        }
    }
}
