package houxiaomu.leetcodeplayground;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello, world!");
//        runSolution("twosum");
//        runSolution("add_two_numbers");
//        runSolution("same_tree");
//        runSolution("symmetric_tree");
//        runSolution("binary_tree_level_order_traversal");
        runSolution("binary_tree_zigzag_level_order_traversal");
    }

    private static void runSolution(String solutionName) {
        String className = Main.class.getPackage().getName() + "." + solutionName + ".Solution";
        try {
            Class<?> clazz = Class.forName(className);
            BaseSolution solution = (BaseSolution) clazz.newInstance();
            solution.runTestCases();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
