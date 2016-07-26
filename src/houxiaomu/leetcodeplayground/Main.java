package houxiaomu.leetcodeplayground;

public class Main {

    public static void main(String[] args) {
//        runSolution("twosum");
//        runSolution("add_two_numbers");
//        runSolution("same_tree");
//        runSolution("symmetric_tree");
//        runSolution("binary_tree_level_order_traversal");
//        runSolution("binary_tree_zigzag_level_order_traversal");
//        runSolution("validate_binary_search_tree");
//        runSolution("restore_ip_addresses");
//        runSolution("reverse_linked_list_ii");
//        runSolution("decode_ways"); //NOT FINISHED
//        runSolution("gray_code");
//        runSolution("partition_list");
//        runSolution("largest_rectangle_in_histogram");
//        runSolution("zigzag_conversion");
//        runSolution("palindrome_number");
//        runSolution("integer_to_roman");
//        runSolution("roman_to_integer");
//        runSolution("longest_common_prefix");
//        runSolution("three_sum");
//        runSolution("three_sum_closest");
//        runSolution("letter_combinations_of_a_phone_number");
//        runSolution("remove_nth_node_from_end_of_list");
//        runSolution("valid_parentheses");
        runSolution("merge_two_sorted_lists");
    }

    private static void runSolution(String solutionName) {
        System.out.println("running "+solutionName);
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
