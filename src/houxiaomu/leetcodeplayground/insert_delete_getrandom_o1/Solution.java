package houxiaomu.leetcodeplayground.insert_delete_getrandom_o1;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {

//    public boolean isFunctionalTestCase(){
//        return true;
//    }

    public Solution() {

    }

    @Override
    public boolean runCustomizedTestCases() {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(1);
        rs.remove(2);
        rs.insert(2);
        int r = rs.getRandom();
        rs.remove(1);
        rs.remove(2);
        r = rs.getRandom();
        return true;
    }
}
