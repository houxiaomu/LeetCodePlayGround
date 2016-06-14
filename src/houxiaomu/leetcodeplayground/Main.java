package houxiaomu.leetcodeplayground;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello, world!");
//        runSolution("twosum");
//        runSolution("addtwonumbers");
        runSolution("sametree");
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
